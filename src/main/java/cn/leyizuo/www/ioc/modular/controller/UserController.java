package cn.leyizuo.www.ioc.modular.controller;

import cn.leyizuo.www.ioc.annotation.CustomAutowired;
import cn.leyizuo.www.ioc.annotation.CustomController;
import cn.leyizuo.www.ioc.annotation.Value;
import cn.leyizuo.www.service.IUserService;

/**
 * @Author： qiusheng
 * @Date： 2019/4/24 14:01
 * @DESCRIPTION：
 * @EMAIL： atticusma@hotmail.com
 */
@CustomController
public class UserController {

    @Value(value="ioc.scan.pathTest")
    private String test;

    @CustomAutowired(value="test")
    private IUserService iUserService;

    public String login(){
        return iUserService.login();
    }

}
