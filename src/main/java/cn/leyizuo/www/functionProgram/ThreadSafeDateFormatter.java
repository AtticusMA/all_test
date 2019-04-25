package cn.leyizuo.www.functionProgram;


import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;

public class ThreadSafeDateFormatter {
    //抽象类不能被实例化；
    public final static ThreadLocal<DateFormatter> formatThreadLocal = ThreadLocal.withInitial(() -> new DateFormatter(new SimpleDateFormat("dd-MM-yyyyy")));
}
