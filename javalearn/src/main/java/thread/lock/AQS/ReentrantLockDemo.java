package thread.lock.AQS;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 最基本的使用场景，就是利用lock和unlock来实现线程同步

 以轮班为实例进行说明，要求一个人下班之后，另一个人才能上班，即不能两个人同时上班，具体实现可以如下

 * Created by Peng.lv on 2017/11/1.
 */
public class ReentrantLockDemo {
    private Lock lock=new ReentrantLock();
    private void workOn(){
        System.out.println(Thread.currentThread().getName()+"：上班！");
    }
    private void workOff(){
        System.out.println(Thread.currentThread().getName()+"：下班！");
    }
    public void work(){
        try{
            lock.lock();
            workOn();
            System.out.println(Thread.currentThread().getName()+"工作中！！！！！！");
            Thread.sleep(100);
            workOff();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] ags)throws InterruptedException{
        final ReentrantLockDemo lockDemo= new ReentrantLockDemo();
        int i=0;
        List<Thread> list =new ArrayList<>(30);
        do{
            Thread a = new Thread(new Runnable() {
                @Override
                public void run() {
                    lockDemo.work();
                }
            },"小A_"+i);
            Thread b = new Thread(new Runnable() {
                @Override
                public void run() {
                    lockDemo.work();
                }
            },"小B_"+i);
            list.add(a);
            list.add(b);
        }while(i++<10);
        for(Thread thread:list){
            thread.start();
        }
        Thread.sleep(3000);
        System.out.println("main over!");
    }
}
