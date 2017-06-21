package thread.returnValue;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 控制线程池中所有线程的执行步骤CyclicBarrier加计数，让一组线程都等待对方达到一个共同的障碍点
 * 举例：五个人（这五个人真无聊..），这次没裁判。规定五个人只要都跑到终点了，大家可以喝啤酒。但是，只要有一个人没到终点，就不能喝。 这里也没有要求大家要同时起跑(当然也可以，加latch)
 * CyclicBarrier强调的是n个线程，大家相互等待，只要有一个没完成，所有人都得等着。正如上例，只有5个人全部跑到终点，大家才能开喝，否则只能全等着。
 * CountDownLatch强调的是一个线程（或多个）需要等待另外的n个线程干完某件事情之后才能继续执行。 上述例子，main线程是裁判，5个AWorker是跑步的。运动员先准备，裁判喊跑，运动员才开始跑（这是第一次同步，对应begin）。5个人谁跑到终点了，countdown一下，直到5个人全部到达，裁判喊停（这是第二次同步，对应end），然后算时间。
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
