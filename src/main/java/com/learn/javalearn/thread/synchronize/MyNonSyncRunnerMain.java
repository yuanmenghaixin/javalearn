package thread.synchronize;

/**
 * Created by Administrator on 2017/2/23.
 */
public class MyNonSyncRunnerMain {
    private static void syncTest() throws InterruptedException {
        MyNonSyncRunner runner = new MyNonSyncRunner();
        Thread thread1 = new Thread(runner);
        Thread thread2 = new Thread(runner);
        thread1.setDaemon(true);
        thread2.setDaemon(true);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

    public static void main(String[] args) throws InterruptedException {
        syncTest();
    }
}
