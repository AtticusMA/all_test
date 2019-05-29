package cn.leyizuo.www.Extends;

public class Human {
    String name = "Human";
    public String getName(){
        return this.name;
    }
    public void happy(){ System.out.println(this.getName()+"会睡觉");}
    public void sleep() {
        System.out.println("Human sleep..");
    }

    public static void main(String[] args) {
        Human h = new Male();// 向上转型，真正实现的子类;子类没有的方法会使用父类
        h.sleep();
        h.happy();
        ((Male) h).speak();
        System.out.println(h.getName());
    }
}

class Male extends Human {
    String name = "Male";
    public String getName(){
        return this.name;
    }
    @Override
    public void sleep() {
        System.out.println("Male sleep..");
    }

    public void speak() {
        System.out.println("I am Male");
    }
}

class Female extends Human {
    String name = "Female";

    public String getName(){
        return this.name;
    }
    @Override
    public void sleep() {
        System.out.println("Female sleep..");
    }

    public void speak() {
        System.out.println("I am Female");
    }
}
