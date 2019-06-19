package cn.leyizuo.www.service.Impl;

import cn.leyizuo.www.ioc.annotation.CustomAutowired;
import cn.leyizuo.www.ioc.annotation.CustomService;
import cn.leyizuo.www.mapping.IUserMapping;
import cn.leyizuo.www.service.IUserService;

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
