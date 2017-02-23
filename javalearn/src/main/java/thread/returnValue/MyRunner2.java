package thread.returnValue;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Administrator on 2017/2/23.
 */
public class MyRunner2 implements Runnable {
    private CyclicBarrier barrier = null;

    public MyRunner2(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    public void run() {
        Random r = new Random();
        try {
            for (int i = 0; i < 3; i++) {
                Thread.sleep(r.nextInt(10) * 1000);
                System.out.println(new Date() + "--" + Thread.currentThread().getName() + "--第" + (i + 1) + "次等待。");
                barrier.await();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
