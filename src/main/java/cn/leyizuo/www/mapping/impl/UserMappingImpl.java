package cn.leyizuo.www.mapping.impl;

import cn.leyizuo.www.ioc.annotation.CustomMapping;
import cn.leyizuo.www.mapping.IUserMapping;

/**
 * @Author： qiusheng
 * @Date： 2019/4/24 14:03
 * @DESCRIPTION：
 * @EMAIL： atticusma@hotmail.com
 */
@CustomMapping
public class UserMappingImpl implements IUserMapping {
    public String login() {
        return "登陆成功";
    }
}
