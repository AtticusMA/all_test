package cn.leyizuo.www.proxy.service.Impl;

import cn.leyizuo.www.proxy.service.IUser;

public class UserImpl implements IUser {
    @Override
    public void save() {
        System.out.println("保存");
    }

    @Override
    public void update() {
        System.out.println("更新");
    }
}
