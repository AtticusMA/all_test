package cn.leyizuo.www.ThreadTest;

public class ThreadTest2 {
    static ThreadTest2  threadTest2 = new ThreadTest2();
    public static void main(String args[]){
          Thread thread1 = new Thread(new Runnable(){
              //synchronized是同步执行方法，其他程序方法无法进入此方法
              @Override
              public synchronized void run(){
                  for(int i=0;i<4;i++){
                      try {
                          Thread.sleep(300);
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                      System.out.println("Thread1 still alive, " + i);
                  }
              }
          });
          new Thread(thread1).start();
          new Thread(thread1).start();
    }
}
