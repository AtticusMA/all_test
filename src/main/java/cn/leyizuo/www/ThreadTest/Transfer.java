package cn.leyizuo.www.ThreadTest;

/**
 * 创建一个实现Runnable接口的类执行多线程
 */
public class Transfer implements Runnable {
    Bank bank;
    public Transfer(Bank bank){
        this.bank = bank;
    }
    @Override
    public void run(){
        for(int i=0;i<10;i++){
            bank.set();
            System.out.println(bank.get());
        }

    }

}
