package cn.leyizuo.www.aop;

import cn.leyizuo.www.aop.service.IUser;
import cn.leyizuo.www.aop.service.impl.OrderDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author： qiusheng
 * @Date： 2019/4/26 14:56
 * @DESCRIPTION：
 * @EMAIL： atticusma@hotmail.com
 */
public class SpringAopApplication {
    public static void main(String args[]){
        //太牛逼了，这样真的能获取到spring的xml文件
        ApplicationContext context = new ClassPathXmlApplicationContext("/springcontext.xml");
        //这样名称的bean真的能获取到bean
        IUser user =(IUser) context.getBean("userImpl");
        System.out.println(user.getClass());
        user.save();
        OrderDao orderDao = (OrderDao)context.getBean("orderDao");
        //没有实现接口的就不能调用代理了么.卧槽，真是这样啊，是节点的路径选错了。
        System.out.println(orderDao.getClass());
        orderDao.save();

    }
}
