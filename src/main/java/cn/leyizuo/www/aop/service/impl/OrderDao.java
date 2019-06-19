package cn.leyizuo.www.aop.service.impl;

import org.springframework.stereotype.Component;

/**
 * @Author： qiusheng
 * @Date： 2019/4/26 15:04
 * @DESCRIPTION：
 * @EMAIL： atticusma@hotmail.com
 */
@Component
public class OrderDao {
    public void save(){
        System.out.println("订单成功保存");
    }
}
