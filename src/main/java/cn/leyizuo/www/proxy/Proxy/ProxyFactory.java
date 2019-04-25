package cn.leyizuo.www.proxy.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    private Object target;
    public ProxyFactory(Object target){
        this.target=target;
    }

    public Object getProxyInstance(){
        //获取代理类及代理接口，
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodname = method.getName();
                Object result = null;
                if("find".equals(methodname)){
                    result = method.invoke(target,args);
                }else{
                    System.out.println("开启事务");
                    result = method.invoke(target,args);
                    System.out.println("提交事务");
                }
                return result;
            }
        });
        return proxy;
    }
}
