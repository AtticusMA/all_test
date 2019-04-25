package cn.leyizuo.www.functionProgram;

public interface Children extends Parent {

    @Override
    public default void welcome(){
        message("children hi");
    }
}
