package thread.synchronize.threadPool.threadPool.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Peng.lv on 2017/10/13.
 * 1. FixedThreadPool是一个典型且优秀的线程池，它具有线程池的高效率和节省创建线程时所耗的开销的优点。但是在线程池空闲时，即线程池中没有可运行任务时，它不会释放工作线程，还会占用一定的系统资源。

 2. CachedThreadPool的特点就是在线程池空闲时，即线程池中没有可运行任务时，它会释放工作线程，从而释放工作线程所占用的资源。但是当出现新任务时，又要创建新的工作线程，这会带来一定的系统开销。并且在使用CachedThreadPool时，一定要注意控制任务的数量，否则大量线程同时运行，可能会造成系统瘫痪。
 */
public class ExecutorsMain {
    private static void syncTest() throws InterruptedException {
        //第一个例子：
        ExecutorService pool = Executors.newFixedThreadPool(2);
        //创建四个任务
        Thread t1 = new Thread();
        Thread t2 = new Thread();
        Thread t3 = new Thread();
        Thread t4 = new Thread();
        //放入线程池
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.shutdown(); //关闭线程池

        //第二个例子：
        ExecutorService pool1 = Executors.newScheduledThreadPool(4);
        Thread t = new Thread();
        //pool1.scheduleAtFixedRate(t,1, 5, TimeUnit.SECONDS);
    }
}
