package thread.synchronize;

/**
 * Created by Administrator on 2017/2/23.
 */
public class MyNonSyncRunner implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start.");
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " Running step " + i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " End.");
    }
}
