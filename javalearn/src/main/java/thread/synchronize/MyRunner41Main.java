package thread.synchronize;

/**
 * Created by Administrator on 2017/2/23.
 */
public class MyRunner41Main {
    private static void sharedVaribleTest() throws InterruptedException {
        MyRunner4 runner4 = new MyRunner4();
        Thread thread1 = new Thread(runner4);
        Thread thread2 = new Thread(runner4);
        thread1.setDaemon(true);//将该线程标记为守护线程或用户线程。
        thread2.setDaemon(true);
        thread1.start();
        thread2.start();
        thread1.join();//等待该线程终止。
        thread2.join();//等待该线程终止。
    }

    public static void main(String[] args) throws InterruptedException {
        // 使用ThreadLocal机制
         /*ThreadLocal是JDK引入的一种机制，它用于解决线程间共享变量，使用ThreadLocal声明的变量，即使在线程中属于全局变量，针对每个线程来讲，这个变量也是独立的。*/
        sharedVaribleTest();
    }
}
