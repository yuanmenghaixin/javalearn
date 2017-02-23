package thread.returnValue;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 使用信号量来控制线程
 */
public class SemaphoreMain {
    //使用信号量来控制线程
    //JDK提供了Semaphore来实现“信号量”的功能，它提供了两个方法分别用于获取和释放信号量：acquire和release，
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        semaphoreTest();
    }

    //JDK提供了Semaphore来实现“信号量”的功能，它提供了两个方法分别用于获取和释放信号量：acquire和release，
    private static void semaphoreTest() {
        ExecutorService exec = Executors.newFixedThreadPool(10);
        final Semaphore semp = new Semaphore(2);
        for (
                int i = 0;
                i < 10; i++) {
            Runnable runner = new Runnable() {
                public void run() {
                    try {
                        semp.acquire();
                        System.out.println(new Date() + " " + Thread.currentThread().getName() + "正在执行。");
                        Thread.sleep(5000);
                        semp.release();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            };
            exec.execute(runner);
        }
        exec.shutdown();
    }
}
