package cn.leyizuo.www.proxy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//为什么使用代理工厂，因为静态代理是实现接口的，当接口改变，静态代理也要变;
//动态代理就是可以直接使用，在拦截到的方法中添加一些功能
public class ProxyFactory {
    //此字段是实例
    private Object target;
    public ProxyFactory(Object target){
        this.target=target;
    }


    public Object getProxyInstance(){
        //获取代理类加载器及其接口，q：为什么一定要接口
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodname = method.getName();
                Object result = null;
                if("find".equals(methodname)){
                    result = method.invoke(target,args);
                }else{
                    System.out.println("代理工厂开启事务");
                    //执行方法还是需要method.invoke(target,args);targets对象实例，args invoke方法获取的参数
                    result = method.invoke(target,args);
                    System.out.println("代理工厂提交事务");
                }
                return result;
            }
        });
        return proxy;
    }
}
