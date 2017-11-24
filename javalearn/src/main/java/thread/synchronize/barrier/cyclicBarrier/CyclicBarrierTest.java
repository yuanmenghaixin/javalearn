package thread.synchronize.barrier.cyclicBarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier主要用于一组固定大小的线程之间，各个线程之间相互等待，当所有线程都完成某项任务之后，才能执行之后的任务
 * 如下场景：
 * 有若干个线程都需要向一个数据库写数据，但是必须要所有的线程都讲数据写入完毕他们才能继续做之后的事情。
 * 分析一下这个场景的特征：
 * 各个线程都必须完成某项任务(写数据)才能继续做后续的任务；
 * 各个线程需要相互等待，不能独善其身。
 * 这种场景便可以利用CyclicBarrier来完美解决。
 * Created by Peng.lv on 2017/11/22.
 * 总结
 CountDownLatch和CyclicBarrier都能够实现线程之间的等待，只不过它们侧重点不同：

 CountDownLatch一般用于某个线程A等待若干个其他线程执行完任务之后，它才执行；
 CyclicBarrier一般用于一组线程互相等待至某个状态，然后这一组线程再同时执行；
 CountDownLatch是不能够重用的，而CyclicBarrier是可以重用的。
 */
public class CyclicBarrierTest {
    private static final int THREAD_NUMBER = 5;
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        //构造函数public CyclicBarrier(int parties, Runnable barrierAction)参数parties表示一共有多少线程参与这次“活动”，参数barrierAction是可选的，用来指定当所有线程都完成这些必须的“神秘任务”之后需要干的事情，所以barrierAction这里的动作在一个相互等待的循环内只会执行一次。
        CyclicBarrier barrier = new CyclicBarrier(THREAD_NUMBER, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getId() + "：我宣布，所有小伙伴写入数据完毕");
            }
        });
        for (int i = 0; i < THREAD_NUMBER; i++) {
            Thread t = new Thread(new Worker(barrier));
            t.start();
        }
    }

    static class Worker implements Runnable {
        private CyclicBarrier barrier;

        public Worker(CyclicBarrier barrier) {
            this.barrier = barrier;
        }
        @Override
        public void run() {
            int time = RANDOM.nextInt(1000);
            System.out.println(Thread.currentThread().getId() + "：我需要" + time + "毫秒时间写入数据.");
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getId() + "：写入数据完毕，等待其他小伙伴...");
            try {
                //本demo只有当五个线程都调用了barrier.await()方法之后才会继续执行后续操作
                barrier.await(); // await函数用来执行等待操作，等待所有线程都调用过此函数才能进行后续动作,
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getId() + "：所有线程都写入数据完毕，继续干活...");
        }
    }
}
