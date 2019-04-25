package cn.leyizuo.www.ThreadTest;

/**
 * 测试ThreadLocal
 */
public class TestThreadLocal {
    public static void main(String args[]) {
        Bank bank = new Bank();
        Transfer transfer = new Transfer(bank);
        Thread thread1 = new Thread(transfer);
        Thread thread2 = new Thread(transfer);
        thread1.start();
        thread2.start();
        //start()时没有直接执行，而是在join时定义同步才执行
        try {
            //main线程停止执行，只执行thread1直到结束；join必须在start之前执行
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            //main线程停止执行，只执行thread2直到结束
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //输出的时main线程的函数
        System.out.println(bank.get());
    }
}
