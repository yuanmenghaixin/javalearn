package thread.returnValue;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * CyclicBarrier主要用于一组固定大小的线程之间，各个线程之间相互等待，当所有线程都完成某项任务之后，才能执行之后的任务
 * 如下场景：
 * 有若干个线程都需要向一个数据库写数据，但是必须要所有的线程都讲数据写入完毕他们才能继续做之后的事情。
 * 分析一下这个场景的特征：
 * 各个线程都必须完成某项任务(写数据)才能继续做后续的任务；
 * 各个线程需要相互等待，不能独善其身。
 * 这种场景便可以利用CyclicBarrier来完美解决。
 *
 * 可以看到，前面四个线程等待最后一个线程超时了，这个时候他们不再等待最后这个小伙伴了，而是抛出异常并都继续后续的动作。
 * 最后这个线程屁颠屁颠地完成写入数据操作之后也继续了后续的动作。需要说明的是，发生了超时异常时候，还没有完成“神秘任务”的线程在完成任务之后不会做任何等待，
 * 而是会直接执行后续的操作。
 * Created by Peng.lv on 2017/11/22.
 */
public class CyclicBarrier_TimeoutTest {
    private static final int THREAD_NUMBER = 5;
    private static final Random RANDOM = new Random();

    public static void main(String[] args) throws InterruptedException {
        //构造函数public CyclicBarrier(int parties, Runnable barrierAction)参数parties表示一共有多少线程参与这次“活动”，参数barrierAction是可选的，用来指定当所有线程都完成这些必须的“神秘任务”之后需要干的事情，所以barrierAction这里的动作在一个相互等待的循环内只会执行一次。
        CyclicBarrier barrier = new CyclicBarrier(THREAD_NUMBER, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getId() + "：我宣布，所有小伙伴写入数据完毕");
            }
        });
        for (int i = 0; i < THREAD_NUMBER; i++) {
            if (i < THREAD_NUMBER - 1) {
                Thread t = new Thread(new Worker(barrier));
                t.start();
            } else {  //最后一个线程故意延迟3s创建。
                Thread.sleep(3000);
                Thread t = new Thread(new Worker(barrier));
                t.start();
            }
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
                // await函数用来执行等待操作，等待所有线程都调用过此函数才能进行后续动作,
                barrier.await(2000, TimeUnit.MILLISECONDS); // 只等待2s，必然会等待最后一个线程超时
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getId() + "：所有线程都写入数据完毕，继续干活...");
        }
    }
}
