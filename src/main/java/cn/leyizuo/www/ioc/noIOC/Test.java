package cn.leyizuo.www.ioc.noIOC;

/**
 * @Author： qiusheng
 * @Date： 2019/4/25 10:01
 * @DESCRIPTION：
 * @EMAIL： atticusma@hotmail.com
 */
public class Test {
    public static void main(String args[]){
        Dependent dependent = new Dependent();
        //为什么依赖不了呢，一个类调用另一个类//因为在dependent类中依赖的util类没有实例化，只是写了一个字段，没有new
        System.out.println(dependent.outString());
    }
}
