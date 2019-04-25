package cn.leyizuo.www.ioc.config;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author qiusheng
 * @Date 2019/4/22 16:45
 * @DESCRIPTION 用ioc中获取配置文件及配置文件中内容
 * @EMALL: atticusma@hotmail.com
 */
public class ConfigUtils {

    /**
     * 配置信息，静态类可以，也可以在构造方法直接调用，就可以在初始化时直接加载了；此字段使用静态的原因时下面getPropertiesByKey使用了static
     */
    private static Properties properties;

    /**
     * 以路径获取配置信息;构造函数是new出来的,static字段不用new就可以;
     * @param path
     */
    public ConfigUtils(String path){
        properties=this.getPropertiesByPath(path);
    }

    /**
     * 默认为/application.properties路径的配置信息，通过文件地址获取输入流，然后转化为Properties类
     * @param path
     * @return
     */
    private Properties getPropertiesByPath(String path) {
        if(StringUtils.isEmpty(path)){
            path="/application.properties";
            //这个路径就是以classes目录下。。。。。。。。。。。。。。。
        }
        //这个是怎么识别到路径的，难道在target中会出现这样的目录
        Properties properties = new Properties();
        //将文件转化为输入流进行读，通过此类的getResourceAsStrean(path)以此类去读取指定路径下的文件转化为输入流。
        InputStream is = ConfigUtils.class.getResourceAsStream(path);
        try{
            System.out.println("正在加载配置文件"+path);
            //使用Properties的load方法可以读取输入流
            properties.load(is);
            return properties;
        }catch(IOException io){
            io.printStackTrace();
        }finally {
            try{
                //应该在finally中关闭输入流
               if(is != null){
                    is.close();
               }
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
        }
        return properties;
    }

    /**
     * 通过获取properties中的key获取值
     * @param key
     * @return
     */
    public static Object getPropertiesByKey(String key){
        if(properties.size()>0 ){
            return properties.getProperty(key);
        }
        return null;
    }



    //此类的放的思维是使用

}
