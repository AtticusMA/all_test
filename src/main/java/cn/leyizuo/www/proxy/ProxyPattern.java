package cn.leyizuo.www.proxy;


import cn.leyizuo.www.proxy.proxy.CglibProxy;
import cn.leyizuo.www.proxy.proxy.ProxyFactory;
import cn.leyizuo.www.proxy.proxy.UserProxy;
import cn.leyizuo.www.proxy.Utils.Common;
import cn.leyizuo.www.service.IUser;
import cn.leyizuo.www.service.Impl.UserImpl;

public class ProxyPattern {
    public static void main(String[] args){
        //实现的类是代理类，代理类也实现了接口，代理原来的接口实现类，所以执行的代理类
        //通常的做法，实现接口
        IUser target = new UserImpl();
        target.save();
        target.update();

        //代理类，在代理类中指明实现类，包装一层，加入拓展的方法
        IUser proxy = new UserProxy(target);
        proxy.save();
        proxy.update();
        System.out.println("用户代理目标对象"+proxy.getClass());
        //代理工厂模式
        IUser factoryProxy = (IUser)new ProxyFactory(target).getProxyInstance();
        System.out.println("工厂代理目标对象"+factoryProxy.getClass());
        //这个方法已经在代理工厂中指明匹配的规则
        factoryProxy.update();


        System.out.println("=======================执行cglib代理模式====================================");
        Common c = new Common();
        CglibProxy cglibProxy=new CglibProxy(c);
        Common co=(Common)cglibProxy.getProxyInstance();
        //的确是执行了，但是如何获得执行后返回参数
        String value=co.sout();
        System.out.println("==============难道真的接收不到返回值么==============");
        System.out.println(value);
        System.out.println("==============可以的哈==============");
        System.out.println("=======================执行cglib代理模式结束====================================");
    }
}
