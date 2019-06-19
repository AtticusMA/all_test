package cn.leyizuo.www.extend;

public class SupClass {
    public void sleep(){
        System.out.println("人必须睡觉");
    }
    public static void main(String args[]){
        SupClass supClass = new SubClass();
        supClass.sleep();//调用方法是子类的方法，实例化的是子类
    }
}

class SubClass extends SupClass{

    @Override
    public void sleep(){
        System.out.println("儿子才睡觉");
    }

    public void eat(){
        System.out.println("必须得吃");
    }
}
