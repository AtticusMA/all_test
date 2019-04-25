package cn.leyizuo.www.ThreadTest;

/**
 * 创建线程的函数
 */
public class Bank {
    ThreadLocal<Integer> t = new ThreadLocal<Integer>(){
        @Override
        protected  Integer initialValue(){
            return 100;
        }
    };
    public int get(){
        return t.get();
    }

    public void set(){
         t.set(t.get()+10);
    }
}
