package thread.synchronize;

/**
 * Created by Administrator on 2017/2/23.
 */
public class MyRunner21Main {
    private static void sharedVaribleTest() throws InterruptedException {
        MyRunner2 runner2 = new MyRunner2();
        Thread thread1 = new Thread(runner2);
        Thread thread2 = new Thread(runner2);
        thread1.setDaemon(true);//将该线程标记为守护线程或用户线程。
        thread2.setDaemon(true);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

    public static void main(String[] args) throws InterruptedException {
//        将“全局变量”降级为“局部变量”

/*既然是共享变量造成的问题，那么我们可以将共享变量改为“不共享”，即将其修改为局部变量。这样也可以解决问题，同样针对上面的示例，这种解决方式的代码如下：*/
        sharedVaribleTest();
    }
}
