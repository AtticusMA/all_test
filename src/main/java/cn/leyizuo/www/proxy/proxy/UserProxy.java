package cn.leyizuo.www.proxy.proxy;


import cn.leyizuo.www.service.IUser;

public class UserProxy implements IUser {
    //在代理中直接指出实现的接口，加入代理的方法 缺点是直接指出实现，不能动态指明
    //private IUser target =new UserImpl();
    //这种方法就是必须在调用接口时必修实例化，指明实现类
    private IUser target;
    public UserProxy(IUser target){
        this.target=target;
    }
    @Override
    public String save() {
        System.out.println("用户代理save之前输出");
        target.save();
        return "保存成功";
    }

    @Override
    public void update() {
        System.out.println("用户代理update之前输出");
        target.update();
    }
}
