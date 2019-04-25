package cn.leyizuo.www.functionProgram;

public class ParentImpl implements Parent {
    @Override
    public void message(String s) {
        System.out.println(s);
    }

    @Override
    public String getLastMessage() {
        return "huoqu";
    }
}
