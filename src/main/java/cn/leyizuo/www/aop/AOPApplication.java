package cn.leyizuo.www.aop;

import cn.leyizuo.www.aop.example.AOPFactory;
import cn.leyizuo.www.aop.example.Aop;
import cn.leyizuo.www.service.IUser;
import cn.leyizuo.www.service.Impl.UserImpl;

/**
 * @Author： qiusheng
 * @Date： 2019/4/26 13:31
 * @DESCRIPTION：
 * @EMAIL： atticusma@hotmail.com
 */
public class AOPApplication {
    public static void main(String args[]){
        //这就是面向横切面，就是使用代理的方法将业务和关注点抽离，将关注点包装一个类，
        //将包装类和业务注入到代理类中，这样就可以拦截到业务，将关注点加入
        //以下方法是使用动态代理的方式
        Aop aop =new Aop();
        IUser iUser = new UserImpl();
        IUser proxy = (IUser)new AOPFactory(aop,iUser).getProxyFactoryInstance();
        String resuleValue=proxy.save();
        System.out.println("打印输出内容:"+resuleValue);
        proxy.update();

        //加入IOC容器的方法
        //使用注解@Component，然后再配置文件中加入bean
//         <bean id="proxy" class="aa.ProxyFactory" factory-method="getProxyInstance">
//             <constructor-arg index="0" ref="userDao"/>
//             <constructor-arg index="1" ref="AOP"/>
//          </bean>
    }
}
