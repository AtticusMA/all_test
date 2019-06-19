package cn.leyizuo.www.service.Impl;

import cn.leyizuo.www.service.IUser;

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
