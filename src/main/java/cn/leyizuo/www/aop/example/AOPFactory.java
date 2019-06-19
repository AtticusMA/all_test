package cn.leyizuo.www.aop.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author： qiusheng
 * @Date： 2019/4/26 13:16
 * @DESCRIPTION： 工厂的静态方法
 * @EMAIL： atticusma@hotmail.com
 */
public class AOPFactory {
    //下面就是静态
    private static Aop aop;
    private static Object target;

    public AOPFactory(Aop aop,Object target){
        this.aop = aop;
        this.target = target;
    }

    //静态方法需要构建实例
    public static Object getProxyFactoryInstance(){
        return getInstanceProxy(aop,target);
    }

    //动态方法,直接将需要切面类和业务代码放入，可以使用接口，实现接口的统一标准，放入
    public static Object getStaticProxyInstance(final Aop aop,final Object target){
        return getInstanceProxy(aop,target);
    }
    //将工厂注入
//    <!--创建工厂-->
//    <bean id="factory" class="aa.ProxyFactory"/>
//
//
//    <!--通过工厂创建代理-->
//    <bean id="IUser" class="aa.IUser" factory-bean="factory" factory-method="getProxyInstance">
//        <constructor-arg index="0" ref="userDao"/>
//        <constructor-arg index="1" ref="AOP"/>
//    </bean>
//
//
//    <context:component-scan base-package="aa"/>

        private static Object getInstanceProxy(Aop aop,Object target){
            return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    Object returnValue=new Object();
                    if (method.getName().equals("save")){
                        aop.transactionBegin();
                        returnValue =method.invoke(target,args);
                        aop.transactionEnd();
                    }else{
                        returnValue=method.invoke(target,args);
                    }
                    return returnValue;
                }
            });
        }

}
