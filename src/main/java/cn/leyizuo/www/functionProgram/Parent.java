package cn.leyizuo.www.functionProgram;

public interface Parent {
     void message(String s);
     //默认方法不需要子类实现，直接使用接口方法输出内容，默认
     default void welcome(){
          message("怎么输出");
     }
     String getLastMessage();
}
