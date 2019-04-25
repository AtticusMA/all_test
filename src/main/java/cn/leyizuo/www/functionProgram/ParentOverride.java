package cn.leyizuo.www.functionProgram;

public class ParentOverride extends ParentImpl {
    @Override
    public void welcome(){
        message("hi ParentOverride");
    }
}
