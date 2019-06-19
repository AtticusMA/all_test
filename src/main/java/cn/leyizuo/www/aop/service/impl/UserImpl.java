package cn.leyizuo.www.aop.service.impl;

import cn.leyizuo.www.aop.service.IUser;
import org.springframework.stereotype.Component;

@Component
public class UserImpl implements IUser {
    @Override
    public String save() {
        System.out.println("保存");
        return "已经成功保存";
    }

    @Override
    public void update() {
        System.out.println("更新");
    }
}
