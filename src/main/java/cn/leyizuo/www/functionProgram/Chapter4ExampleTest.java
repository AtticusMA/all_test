package cn.leyizuo.www.functionProgram;

import java.util.Optional;

public class Chapter4ExampleTest {
    public static void main(String args[]){
        //int类型省去封装统计方法
//        IntSummaryStatistics userage = StaticCollection.getTUsers().stream().mapToInt(user->user.getAge()).summaryStatistics();
//        System.out.printf("max:%d,min:%d,Ave:%f,Sum:%d",userage.getMax(),userage.getMin(),userage.getAverage(),userage.getSum());
//        Parent parent = new ParentImpl();
//        parent.welcome();
//        Children children = new ChildrenImpl();
//
//        children.welcome();
//        children.getLastMessage();//为什么没有输出呢
//        children.message("lala");
//        Parent parent1 = new ChildrenImpl();
//        parent1.welcome();
//        Parent parent2 = new ParentOverride();
//        parent2.welcome();
        Children children = new ChildrenOverride();
        children.welcome();
        Optional<String> emptyOptional = Optional.of("a");
        if("b"==emptyOptional.orElse("b")){
            System.out.println("Optional.orElse将Null赋值");
        }else{
            System.out.println("不为null就不能赋值");
        }

        int a =127;
        int b = 127;
        if(a==b){
            System.out.println("-127到128范围内==true");
        }
        Integer c=new Integer(128);
        Integer d=new Integer(128);
        if(c.equals(d)){
            System.out.println("不在-127到128范围内==true");
        }
        String e="String";
        String f="String";
        if(e.equals(f)){
            System.out.println("true");
        }
    }
}
