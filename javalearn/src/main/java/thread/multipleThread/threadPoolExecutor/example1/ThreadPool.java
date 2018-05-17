package thread.multipleThread.threadPoolExecutor.example1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    private static final int CORE_SIZE = 2;

    private static final int MAX_SIZE = 3;

    private static final long KEEP_ALIVE_TIME = 30;

    private static final int QUEUE_SIZE = 2000000;

    private static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(CORE_SIZE, MAX_SIZE, KEEP_ALIVE_TIME,
            TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(QUEUE_SIZE), new ThreadPoolExecutor.AbortPolicy());

    public static ThreadPoolExecutor getThreadPool() {
        System.out.println(threadPool.getCompletedTaskCount());
        return threadPool;
    }

    public static void shutdown(){
        if(null!=threadPool){
            threadPool.shutdown();
        }
    }
}