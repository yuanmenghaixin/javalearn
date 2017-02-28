package thread.synchronize;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2017/2/23.
 */
public class SyncTestMain {
    private static void syncTest3() throws InterruptedException {
        final List<Integer> list = new ArrayList<Integer>();
        Thread thread1 = new Thread() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + " Start.");
                Random r = new Random(100);
                synchronized (list) {
                    for (int i = 0; i < 5; i++) {
                        list.add(new Integer(r.nextInt()));
                    }
                    System.out.println("The size of list is " + list.size());
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " End.");
            }
        };
        Thread thread2 = new Thread() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + " Start.");
                Random r = new Random(100);
                synchronized (list) {
                    for (int i = 0; i < 5; i++) {
                        list.add(new Integer(r.nextInt()));
                    }
                    System.out.println("The size of list is " + list.size());
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " End.");
            }
        };
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

    public static void main(String[] args) throws InterruptedException {
//　在线程同步的话题上，synchronized是一个非常重要的关键字。它的原理和数据库中事务锁的原理类似。我们在使用过程中，应该尽量缩减synchronized覆盖的范围，原因有二：1）被它覆盖的范围是串行的，效率低；2）容易产生死锁。我们来看下面的示例：
        //示例中线程休眠的操作显然不应该包括在里面。
        syncTest3();
    }
}
