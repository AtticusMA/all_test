package cn.leyizuo.www.proxy;


import cn.leyizuo.www.proxy.Proxy.ProxyFactory;
import cn.leyizuo.www.proxy.Proxy.UserProxy;
import cn.leyizuo.www.proxy.service.IUser;
import cn.leyizuo.www.proxy.service.Impl.UserImpl;

public class ProxyPattern {
    public static void main(String[] args){
        //实现的类是代理类，代理类也实现了接口，代理原来的接口实现类，所以执行的代理类
        IUser proxy = new UserProxy();
        proxy.save();
        proxy.update();

        //代理工厂模式
        //指明接口的实现类
        IUser target = new UserImpl();
        System.out.println("目标对象"+target.getClass());
        IUser factoryProxy = (IUser)new ProxyFactory(target).getProxyInstance();
        System.out.println("代理对象"+factoryProxy.getClass());
        //这个方法已经在代理工厂中指明匹配的规则
        factoryProxy.update();
    }
}
