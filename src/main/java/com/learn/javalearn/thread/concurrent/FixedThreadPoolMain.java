package thread.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 这是一个指定容量的线程池，即我们可以指定在同一时间，线程池中最多有多个线程在运行，超出的线程，需要等线程池中有空闲线程时，才能有机会运行.
 */
public class FixedThreadPoolMain {
    private static void fixedThreadPoolTest() {
        ExecutorService exec = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            MyRunner runner = new MyRunner();
            exec.execute(runner);
        }
        exec.shutdown();
    }

    public static void main(String[] args) {
        fixedThreadPoolTest();
    }
}
