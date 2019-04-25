package cn.leyizuo.www.functionProgram;

public class ChildrenImpl implements Children {

    @Override
    public void message(String s) {
        System.out.println(s);
    }

    @Override
    public String getLastMessage() {
        return "zilei";
    }
}
