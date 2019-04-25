package cn.leyizuo.www.ioc.core;

import cn.leyizuo.www.ioc.annotation.*;
import cn.leyizuo.www.ioc.config.ConfigUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @Author： qiusheng
 * @Date： 2019/4/22 17:06
 * @DESCRIPTION：
 * @EMAIL： atticusma@hotmail.com
 */
public class IOCApplicationContext {
    /**
     * 装载所有类，key为类名（类名首字母小写），value为实例,
     */
    private Map<String,Object> iocBeanMap = new ConcurrentHashMap<String, Object>(32);

    /**
     * 类集合，存放所有的全限制名
     */
    private Set<String> classSet=new HashSet<String>();
    
    public IOCApplicationContext() throws InstantiationException,IllegalAccessException,ClassNotFoundException{
        this.classLoader();
    }

    private void classLoader() throws InstantiationException,IllegalAccessException,ClassNotFoundException {
        new ConfigUtils(null);
        String scanPackagePath = (String)ConfigUtils.getPropertiesByKey("ioc.scan.path");
        if(StringUtils.isNotEmpty(scanPackagePath)){
            scanPackagePath=scanPackagePath.replace(".","/");
        }else{
            throw new RuntimeException("请检查配置文件名称或者配置文件的key值，未能获取到扫描的路径");
        }
        //获取配置文件扫描路径包中的所有文件
        getPackageClassFile(scanPackagePath);
        for(String className:classSet){
            //将使用类注解class加载到容器内,参数是Class类,这个类名是全称
            addServiceToIoc(Class.forName(className));
        }
        //迭代容器内的类，依赖注入
        Set<String> beanKeySet =iocBeanMap.keySet();
        for(String beanName:beanKeySet){
            //因为hashset是没有顺序的，所以会出现类实例多次注入，解决办法就是使用
            addAutowiredToField(iocBeanMap.get(beanName));
        }

    }

    /**
     * 获取路径下所有的class文件
     * @param scanPackagePath
     */
    private void getPackageClassFile(String scanPackagePath) throws IllegalAccessException {
        //获取包名的文件，通过URL类，然后Class类的getClassLoader()方法getResource()就可以获取路径
        // ?第一次就能获取到Url第二次就不能获得，因为第一次得到的路径是相对路径，第二次得到是完全的路径
        URL url = this.getClass().getClassLoader().getResource(scanPackagePath);
        //生成文件
        File file = new File(url.getFile());
        //判断文件是否是路径，和存在
        if(file.exists()&&file.isDirectory()){
            File[] files = file.listFiles();
            for(File scanfile:files){
                if(scanfile.isDirectory()){
                    //这种方式是否能获取到文件，还是使用教程上，
                    // scanfile.getPath是完全路径，要相对路径，因为this.getClass().getClassLoader().getResource()会将绝对路径加上
                    //getPackageClassFile(scanfile.getPath());
                    getPackageClassFile(scanPackagePath+"/"+scanfile.getName());
                }else{
                    if(scanfile.getName().endsWith(".class")){
                        System.out.println("正在扫描："+scanPackagePath.replace("/",",")+"."+scanfile.getName());
                        classSet.add(scanPackagePath.replace("/",".")+"."+scanfile.getName().replace(".class",""));
                    }
                }
            }
        }else{
            throw new IllegalAccessException("不能发现此包名下文件，请校验包名");
        }
    }

    /**
     * 将service注解的类加入到ioc容器内
     * @param classZ
     */
    private void addServiceToIoc(Class<?> classZ) throws  IllegalAccessException,InstantiationException {
        if(classZ.getAnnotation(CustomController.class)!= null){
            String lowerClassName=StringUtils.uncapitalize(classZ.getSimpleName());
            System.out.println("控制反转访问控制层："+ lowerClassName);
            iocBeanMap.put(lowerClassName,classZ.newInstance());
        }
        //一般接口都没有注入，只是在实现类中注入，而注入的一般都是实现类，所以调用和实现松耦合了，所以依赖注入必须将所有类注解注入。
        else if(classZ.getAnnotation(CustomService.class) !=null){
            CustomService customService = classZ.getAnnotation(CustomService.class);
            String lowerClassName = StringUtils.uncapitalize(classZ.getSimpleName());
            System.out.println("控制反转访问服务层:"+lowerClassName);
            iocBeanMap.put(customService.value()=="" ? lowerClassName :customService.value(),classZ.newInstance());
        }else if(classZ.getAnnotation(CustomMapping.class) != null){
            CustomMapping customMapping=classZ.getAnnotation(CustomMapping.class);
            String lowerClassName =  StringUtils.uncapitalize(classZ.getSimpleName());
            System.out.println("控制反转访问映射:"+lowerClassName);
            iocBeanMap.put(StringUtils.isEmpty(customMapping.value()) ? lowerClassName :customMapping.value(),classZ.newInstance());
        }
    }

    /**
     *依赖注入  注意注意set注入方法第二参数时实例，不是class
     * @param o
     */
    private void addAutowiredToField(Object o) throws IllegalAccessException, InstantiationException {
        //Field[] fields = ((Class)o).getDeclaredFields(); 为什么这种方式不可以，这种是强制转换，拆箱。object是实例不是class
        Field[] fields = o.getClass().getDeclaredFields();
        for(Field f:fields){
            CustomAutowired customAutowired=f.getAnnotation(CustomAutowired.class);
            if(customAutowired!=null){
                f.setAccessible(true);
                Class<?> vClass=f.getType();
                if(vClass.isInterface()){
                    //如果是接口判断annotation中是否有value
                    if(StringUtils.isNotBlank(customAutowired.value())){
                        //执行
                        f.set(o,iocBeanMap.get(customAutowired.value()));
                        addAutowiredToField(f.getType());
                    }else{
                        //当接口的实现类和属性一样名字的时候
                        Object targetObj = iocBeanMap.get(f.getName());
                        if(targetObj !=null){
                            f.set(o,targetObj);
                            addAutowiredToField(f.getType());
                        }else{
                            //当属性的名字和实现类不同时就需要查找实现类
                            List<Object> list=getImplInterfaceListByIOC(vClass);
                            if(list.size()==1){
                                //Class implClass = (Class)list.get(0);
                                //为什么这个会报错呢
                                //Can not set cn.leyizuo.www.ioc.modular.mapping.IUserMapping field cn.leyizuo.www.ioc.modular.service.impl.UserServiceImpl.iUserMapping to java.lang.Class
                                f.set(o,list.get(0));
                                //注入一个类就要递归的依赖注入类的属性类
                                addAutowiredToField(f.getType());
                            }else{
                                throw new RuntimeException("当前类"+ o.getClass().getName()+"属性"+f.getName()+"不能正确获取到实现类");
                            }
                        }
                    }
                }else{
                    //不是接口的情况下，直接获取类，注入即可
                    String lowerName =StringUtils.isEmpty(customAutowired.value())? StringUtils.uncapitalize(vClass.getName()):customAutowired.value();
                    Object beanOject = iocBeanMap.get(lowerName);
                    f.set(o,beanOject==null ? f.getType().newInstance():beanOject);
                    addAutowiredToField(iocBeanMap.get(lowerName));
                }
            }
            if(f.getAnnotation(Value.class) != null){
                f.setAccessible(true);
                Value v=f.getAnnotation(Value.class);
                f.set(o,StringUtils.isNotEmpty(v.value())?ConfigUtils.getPropertiesByKey(v.value()):null);
                System.out.println("注入配置文件："+o.getClass().getName()+"加载配置属性"+v.value());
            }
        }
    }


    /**
     * 需要时实例化的类并不是类，ok
     */
    private List<Object> getImplInterfaceListByIOC(Class vClass){
        Set<Map.Entry<String,Object>> classS = iocBeanMap.entrySet();
        List<Object> impllist=new ArrayList<Object>();
        Iterator iterator=classS.iterator();
        while(iterator.hasNext()){
            Map.Entry entry =(Map.Entry)iterator.next();
            Object o=entry.getValue();
            Class[] interfaces =o.getClass().getInterfaces();
            if(ArrayUtils.contains(interfaces,vClass)){
                impllist.add(o);
            }
        }
        return impllist;
    }


    public Object getIOCBean(String beanName){
        if(iocBeanMap!=null){
            return iocBeanMap.get(StringUtils.uncapitalize(beanName));
        }
        return null;
    }


}
