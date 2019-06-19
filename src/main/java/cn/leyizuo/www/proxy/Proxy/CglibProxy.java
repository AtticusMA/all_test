package cn.leyizuo.www.proxy.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author： qiusheng
 * @Date： 2019/4/26 10:22
 * @DESCRIPTION：
 * @EMAIL： atticusma@hotmail.com
 */
public class CglibProxy implements MethodInterceptor {
    private Object target;
    public CglibProxy(Object target){
        this.target=target;
    }

    public Object getProxyInstance(){
        //工具类，执行创建子类
        Enhancer en = new Enhancer();
        en.setSuperclass(target.getClass());
        en.setCallback(this);
        return en.create();
    }

    /**
     * 这么多的参数都是干嘛的
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Cglib执行了拦截");
        Object returnValue = method.invoke(target,objects);
        System.out.println("Cglib拦截结束");
        return returnValue;
    }
}
