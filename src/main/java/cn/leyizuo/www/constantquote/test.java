package cn.leyizuo.www.constantquote;

import cn.leyizuo.www.entity.User;

public class test {
    public static void main(String args[]){
//        int a,b;
//        a=1;
//        b=a;
//        //a重新指向3字面量
//        a=3;
//        //常量，这也不是指向的问题啊
//        System.out.println(b);
//        User user1 = new  User("asdas","asdas",1);
//        User user2 = new User();
//        user2 = user1;
//        user1.setName("nihao");
//        //这是引用类型，user1改变了，user2就变了。他们存储的只是地址，所以指向的值变了。
//        System.out.println(user2);
        String a1 = new String("ab"); // a 为一个引用
        String b1 = new String("ab"); // b为另一个引用,对象的内容一样
        String aa = "ab"; // 放在常量池中
        String bb = "ab"; // 从常量池中查找
        if (aa == bb) // true
            //为什么有一次属性值和字符串对比就是不同的结果
            System.out.println("字符串字面值==比较相等");
        if (a1 == b1) // false，非同一对象
            System.out.println("对象==比较相等");
        if (a1.equals(b1)) // true
            System.out.println("a1,b1对象equals比较相等");
        if (42 == 42.0) { // true
            System.out.println("字面值==相等");
        }

        User user1 = new User(1L,"nihao","liran",12);
        User user2 = new User(2L,"nihao","liran",12);
        if(user1 instanceof User){
            System.out.println("user1==user2");
        }
        if(user1.equals(user2)){
            System.out.println("user1.equals(user2)");
        }

    }

}
