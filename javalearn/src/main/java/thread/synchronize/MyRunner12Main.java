package thread.synchronize;

/**
 * Created by Administrator on 2017/2/23.
 */
public class MyRunner12Main {
    private static void sharedVaribleTest() throws InterruptedException {
//        MyRunner runner = new MyRunner();
//        Thread thread1 = new Thread(runner);
//        Thread thread2 = new Thread(runner);
        Thread thread1 = new Thread(new MyRunner());
        Thread thread2 = new Thread(new MyRunner());
        thread1.setDaemon(true);//将该线程标记为守护线程或用户线程。
        thread2.setDaemon(true);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

    public static void main(String[] args) throws InterruptedException {
        //将“单对象多线程”修改成“多对象多线程”
       /* 同步问题一般发生在“单对象多线程”的场景中，那么最简单的处理方式就是将运行模型修改成“多对象多线程”的样子，针对上面示例中的同步问题，修改后的代码如下：*/
        sharedVaribleTest();
    }
}
