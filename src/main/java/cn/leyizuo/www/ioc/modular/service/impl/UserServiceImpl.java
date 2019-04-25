package cn.leyizuo.www.ioc.modular.service.impl;

import cn.leyizuo.www.ioc.annotation.CustomAutowired;
import cn.leyizuo.www.ioc.annotation.CustomService;
import cn.leyizuo.www.ioc.modular.mapping.IUserMapping;
import cn.leyizuo.www.ioc.modular.service.IUserService;

/**
 * @Author： qiusheng
 * @Date： 2019/4/24 14:02
 * @DESCRIPTION：
 * @EMAIL： atticusma@hotmail.com
 */
@CustomService(value="test")
public class UserServiceImpl implements IUserService {

    @CustomAutowired
    private IUserMapping iUserMapping;

    public String login() {
        return iUserMapping.login();
    }
}
