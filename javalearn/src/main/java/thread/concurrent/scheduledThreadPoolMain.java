package thread.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * 　这和我们平时使用的ScheduledTask比较类似，或者说很像Timer，它可以使得一个线程在指定的一段时间内开始运行，并且在间隔另外一段时间后再次运行，直到线程池关闭。
 */
public class scheduledThreadPoolMain {
    private static void scheduledThreadPoolTest() {
        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);
        MyRunner runner = new MyRunner();
        //scheduleAtFixedRate创建并执行一个在给定初始延迟后首次启用的定期操作，后续操作具有给定的周期；也就是将在 initialDelay 后开始执行，然后在 initialDelay+period 后执行，接着在 initialDelay + 2 * period 后执行，依此类推
        final ScheduledFuture<?> handler1 = scheduler.scheduleAtFixedRate(runner, 1, 10, TimeUnit.SECONDS);
        //scheduleWithFixedDelay创建并执行一个在给定初始延迟后首次启用的定期操作，随后，在每一次执行终止和下一次执行开始之间都存在给定的延迟
        final ScheduledFuture<?> handler2 = scheduler.scheduleWithFixedDelay(runner, 2, 10, TimeUnit.SECONDS);
        //	schedule(Runnable command, long delay, TimeUnit unit) 创建并执行在给定延迟后启用的一次性操作。
        scheduler.schedule(new Runnable() {
                               public void run() {
                                   handler1.cancel(true);//cancel(boolean mayInterruptIfRunning)试图取消对此任务的执行。
                                   handler2.cancel(true);
                                   scheduler.shutdown();//启动一次顺序关闭，执行以前提交的任务，但不接受新任务。
                               }
                           }, 30, TimeUnit.SECONDS
        );
    }

    public static void main(String[] args) {
        scheduledThreadPoolTest();
    }
}
