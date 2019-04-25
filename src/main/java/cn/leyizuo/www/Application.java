package cn.leyizuo.www;

import cn.leyizuo.www.ioc.core.IOCApplicationContext;
import cn.leyizuo.www.ioc.modular.controller.UserController;

/**
 * @Author： qiusheng
 * @Date： 2019/4/24 14:13
 * @DESCRIPTION：
 * @EMAIL： atticusma@hotmail.com
 */
public class Application {
    public static void main(String args[]) throws Exception{
        IOCApplicationContext context=new IOCApplicationContext();
        //MyApplicationContext context=new MyApplicationContext();
        UserController userController=(UserController)context.getIOCBean("UserController");
        String login =userController.login();
        System.out.println(login);
    }

}
