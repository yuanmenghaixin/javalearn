package thread.returnValue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 实现生产者-消费者模型
 */
public class BlockingQueueMain {
    //实现生产者-消费者模型
    public static void main(String[] args) {
        blockingQueueTest();
    }

    //对于生产者-消费者模型来说，我们应该都不会陌生，通常我们都会使用某种数据结构来实现它。在concurrent工具包中，我们可以使用BlockingQueue来实现生产者-消费者模型，
    //我们定义了两个线程，一个线程向Queue中添加数据，一个线程从Queue中取数据。我们可以通过控制maxSleepTimeForSetter和maxSleepTimerForGetter的值，来使得程序得出不同的结果
    private static void blockingQueueTest() {
        final BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();//线程安全通过可重入锁实现ReentrantLock
        final int maxSleepTimeForSetter = 10;
        final int maxSleepTimerForGetter = 10;

        Runnable setter = new Runnable() {
            @Override
            public void run() {
                Random r = new Random();
                while (true) {
                    int value = r.nextInt(100);
                    try {
                        queue.put(new Integer(value));
                        System.out.println(Thread.currentThread().getName() + "---向队列中插入值" + value);
                        Thread.sleep(r.nextInt(maxSleepTimeForSetter) * 1000);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };

        Runnable getter = new Runnable() {
            @Override
            public void run() {
                Random r = new Random();
                while (true) {
                    try {
                        if (queue.size() == 0) {
                            System.out.println(Thread.currentThread().getName() + "---队列为空");
                        } else {
                            int value = queue.take().intValue();//获取并移除此队列的头部，在元素变得可用之前一直等待（如果有必要）。
                            System.out.println(Thread.currentThread().getName() + "---从队列中获取值" + value);
                        }
                        Thread.sleep(r.nextInt(maxSleepTimerForGetter) * 1000);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };

        ExecutorService exec = Executors.newFixedThreadPool(2);
        exec.execute(setter);
        exec.execute(getter);
    }
}
