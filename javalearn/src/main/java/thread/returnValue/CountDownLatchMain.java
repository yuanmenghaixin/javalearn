package thread.returnValue;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 控制线程池中所有线程的执行步骤：CountDownLatch减计数，允许一个或多个线程等待其他线程正在执行的一组操作完成
 * 举例：有五个人，一个或者多个裁判。这五个人同时跑，裁判开始计时，五个人都到终点了，裁判喊停，然后统计这五个人从开始跑到最后一个撞线用了多长时间
 */
public class CountDownLatchMain {
    //控制线程池中所有线程的执行步骤
    public static void main(String[] args) throws InterruptedException {
        countdownLatchTest();
    }

    //CountDownLatch则是采取类似”倒计时计数器”的机制来控制线程池中的线程，它有CountDown和Await两个方法。示例代码如下：
    private static void countdownLatchTest() throws InterruptedException {
        final CountDownLatch begin = new CountDownLatch(1);
        final CountDownLatch end = new CountDownLatch(5);
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            Runnable runner = new Runnable() {
                public void run() {
                    Random r = new Random();
                    try {
                        begin.await();
                        System.out.println(Thread.currentThread().getName() + "运行开始");
                        Thread.sleep(r.nextInt(10) * 1000);
                        System.out.println(Thread.currentThread().getName() + "运行结束");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    } finally {
                        end.countDown();
                    }
                }
            };
            exec.execute(runner);
        }
        begin.countDown();
        end.await();
        System.out.println(Thread.currentThread().getName() + "运行结束");
        exec.shutdown();
    }
}
