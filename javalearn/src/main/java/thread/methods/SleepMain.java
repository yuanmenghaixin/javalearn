package thread.methods;

import java.io.IOException;

/**
 * Created by Peng.lv on 2018/5/17.
 * 方法sleep()的作用是在指定的毫秒数内让当前“正在执行的线程”休眠（暂停执行）。这个“正在执行的线程”是指this.currentThread()返回的线程。

 sleep方法有两个重载版本：

 1
 2
 sleep(long millis)     //参数为毫秒
 sleep(long millis,int nanoseconds)    //第一参数为毫秒，第二个参数为纳秒
 sleep相当于让线程睡眠，交出CPU，让CPU去执行其他的任务。
 但是有一点要非常注意，sleep方法不会释放锁，也就是说如果当前线程持有对某个对象的锁，则即使调用sleep方法，其他线程也无法访问这个对象。看下面这个例子就清楚了：
 */
public class SleepMain {
    private int i = 10;
    private Object object = new Object();

    public static void main(String[] args) throws IOException {
        SleepMain test = new SleepMain();
        MyThread thread1 = test.new MyThread();
        MyThread thread2 = test.new MyThread();
        thread1.start();
        thread2.start();
    }

    class MyThread extends Thread{
        @Override
        public void run() {
            synchronized (object) {
                i++;
                System.out.println("i:"+i);
                try {
                    System.out.println("线程"+Thread.currentThread().getName()+"进入睡眠状态");
                    Thread.currentThread().sleep(10000);
                } catch (InterruptedException e) {
                    // TODO: handle exception
                }
                System.out.println("线程"+Thread.currentThread().getName()+"睡眠结束");
                i++;
                System.out.println("i:"+i);
            }
        }
    }
}
