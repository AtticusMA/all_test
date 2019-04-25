package cn.leyizuo.www.functiontest;

public class test {
    public static void main(String args[]){
        FunctionClass functionClass = new FunctionClass();
        //这个为什么就可以直接使用lambda
        int result = functionClass.compute(5,value->value*value);
        System.out.println(result);
    }
}
