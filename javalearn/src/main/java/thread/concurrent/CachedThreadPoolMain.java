package thread.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 这是另外一种线程池，它不需要指定容量，只要有需要，它就会创建新的线程
 */
public class CachedThreadPoolMain {
    private static void cachedThreadPoolTest() {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            MyRunner runner = new MyRunner();
            exec.execute(runner);
        }
        exec.shutdown();
    }

    public static void main(String[] args) {
        cachedThreadPoolTest();
    }
}
