package thread.returnValue.Callable.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Peng.lv on 2017/6/16.
 * 举例：有五个人，一个或者多个裁判。这五个人同时跑，裁判开始计时，五个人都到终点了，裁判喊停，然后统计这五个人从开始跑到最后一个撞线用了多长时间
 * countDown方法，当前线程调用此方法，则计数减一
 * awaint方法，调用此方法会一直阻塞当前线程，直到计时器的值为0
 * 举例：CountDownLatch强调的是一个线程（或多个）需要等待另外的n个线程干完某件事情之后才能继续执行。 上述例子，main线程是裁判，5个AWorker是跑步的。运动员先准备，裁判喊跑，运动员才开始跑（这是第一次同步，对应begin）。5个人谁跑到终点了，countdown一下，直到5个人全部到达，裁判喊停（这是第二次同步，对应end），然后算时间。
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        final int num = 5;
        final CountDownLatch begin = new CountDownLatch(1);
        final CountDownLatch end = new CountDownLatch(num);

        for (int i = 0; i < num; i++) {
            new Thread(new AWorker(i, begin, end)).start();
        }

        // judge prepare...
        try {
            Thread.sleep((long) (Math.random() * 9000));
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("judge say : run !");
        begin.countDown();//这个函数用来将CountDownLatch的计数值减一
        long startTime = System.currentTimeMillis();
        try {
            end.await();//让线程阻塞等待其他线程，直到CountDownLatch的计数值变为0才继续执行之后的操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.println("judge say : all arrived !");
            System.out.println("spend time: " + (endTime - startTime));
        }

    }

}

class AWorker implements Runnable {
    final CountDownLatch begin;
    final CountDownLatch end;
    final int id;

    public AWorker(final int id, final CountDownLatch begin,
                   final CountDownLatch end) {
        this.id = id;
        this.begin = begin;
        this.end = end;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.id + " ready !");
            begin.await();//让线程阻塞等待其他线程，直到CountDownLatch的计数值变为0才继续执行之后的操作
           /* // run...
            Thread.sleep((long) (Math.random() * 10000));*/
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println(this.id + " arrived !");
            end.countDown();
        }
    }
}
