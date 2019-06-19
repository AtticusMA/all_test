package cn.leyizuo.www.aop.example;



/**
 * @Author： qiusheng
 * @Date： 2019/4/26 13:18
 * @DESCRIPTION：
 * @EMAIL： atticusma@hotmail.com
 */
public class Aop {
    public void transactionBegin(){
        System.out.println("面向横切面的事务开始");
    }
    public void transactionEnd(){
        System.out.println("面向横切面的事务结束");
    }
}
