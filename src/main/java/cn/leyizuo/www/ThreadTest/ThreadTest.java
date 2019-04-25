package cn.leyizuo.www.ThreadTest;

public class ThreadTest {
    //进程不是互斥的，方法定义是同步的，是互斥的
    public synchronized void method1() throws InterruptedException {
        System.out.println("method1 begin at "+System.currentTimeMillis());
        Thread.sleep(6000);
        System.out.println("method1 end at " + System.currentTimeMillis());
    }
    public synchronized void method2() throws InterruptedException {
        //这个是循环的原因，这是一个段时间识别的方法，因为进程2没有停止，所以在一直执行方法。进程什么时间停止，就不再继续判断了
        while(true){
            System.out.println("method2 running");
            Thread.sleep(200);
        }
    }
    static ThreadTest instance = new ThreadTest();
    public static void main(String args[]){
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    instance.method1();
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
                for (int i = 0; i < 4; i++) {
                    try {
                        Thread.sleep(600); //确实跟这个进程等待的时间有关，等待的时间长，执行了进程2
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                    System.out.println("method1 is alive");
                }
            }
        });

        Thread thread2 = new Thread(new Runnable(){
            @Override
            public void run(){
                try{
                    instance.method2();
                }catch(InterruptedException ie){
                    ie.printStackTrace();
                }
            }
        });
        //这两个进程各自异步执行，进程内容方法同步执行。两个进程没法确定是否执行了？？？？？所以使用while时就产生了循环
        thread1.start();
        //进程2为什么会执行那么多次
        thread2.start();
    }
}

//进程1执行的时候，进程2也已经启动，但是方法1因为是同步的，必须一步步执行，方法2就没有执行。当执行循环的时候进程2执行方法2，执行循环的时候同样也执行的方法2.
//为什么进程2中方法被多次调用，因为while是持续一段时间解析才会执行，进程不是持续一段时间执行的？？？？？？这个貌似不确定啊
