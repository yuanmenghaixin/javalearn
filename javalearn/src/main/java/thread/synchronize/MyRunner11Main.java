package thread.synchronize;

/**
 * Created by Administrator on 2017/2/23.
 */
public class MyRunner11Main {
    private static void sharedVaribleTest() throws InterruptedException {
        MyRunner runner = new MyRunner();
        Thread thread1 = new Thread(runner);
        Thread thread2 = new Thread(runner);
        thread1.setDaemon(true);//将该线程标记为守护线程或用户线程。
        thread2.setDaemon(true);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

    public static void main(String[] args) throws InterruptedException {
        /*　这个示例中，线程用来计算1到100的和是多少，我们知道正确结果是5050（好像是高斯小时候玩过这个？），但是上述程序返回的结果是10100，原因是两个线程同时对sum进行操作。*/
        sharedVaribleTest();
    }
}
