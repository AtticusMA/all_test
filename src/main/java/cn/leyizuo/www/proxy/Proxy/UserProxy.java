package cn.leyizuo.www.proxy.Proxy;


import cn.leyizuo.www.proxy.service.IUser;
import cn.leyizuo.www.proxy.service.Impl.UserImpl;

public class UserProxy implements IUser {
    //在代理中直接指出实现的接口，加入代理的方法
    private IUser target =new UserImpl();
    @Override
    public void save() {
        System.out.println("代理save之前输出");
        target.save();
    }

    @Override
    public void update() {
        System.out.println("代理update之前输出");
        target.update();
    }
}
