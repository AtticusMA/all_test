package cn.leyizuo.www.ioc.noIOC;

/**
 * @Author： qiusheng
 * @Date： 2019/4/25 10:00
 * @DESCRIPTION：
 * @EMAIL： atticusma@hotmail.com
 */
public class Dependent {
    private Utils utils;
    public String outString(){
        return utils.outString();
    }
}
