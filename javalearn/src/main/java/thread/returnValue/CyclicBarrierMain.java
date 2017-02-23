package thread.returnValue;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 控制线程池中所有线程的执行步骤
 */
public class CyclicBarrierMain {
    //控制线程池中所有线程的执行步骤
    public static void main(String[] args) {
        cyclicBarrierTest();
    }

    //在前面，我们已经提到，可以用synchronized关键字来控制单个线程中的执行步骤，那么如果我们想要对线程池中的所有线程的执行步骤进行控制的话，应该如何实现呢？
    //　我们有两种方式，一种是使用CyclicBarrier，一种是使用CountDownLatch。
    //　　CyclicBarrier使用了类似于Object.wait的机制，它的构造函数中需要接收一个整型数字，用来说明它需要控制的线程数目，当在线程的run方法中调用它的await方法时，它会保证所有的线程都执行到这一步，才会继续执行后面的步骤
    private static void cyclicBarrierTest() {
        CyclicBarrier barrier = new CyclicBarrier(3);

        ExecutorService exec = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            exec.execute(new MyRunner2(barrier));
        }
        exec.shutdown();
    }
}
