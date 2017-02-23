package thread.returnValue;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 控制线程池中所有线程的执行步骤
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
