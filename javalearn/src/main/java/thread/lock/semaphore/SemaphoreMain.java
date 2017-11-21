package thread.lock.semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * 信号量模拟上厕所
 * Created by Peng.lv on 2017/11/20.
 */
public class SemaphoreMain {
    public static void main(String[] args) throws Exception {
        Semaphore wc = new Semaphore(3, true); // 3个坑位
        for (int i = 1; i <= 6; i++) {
            Thread t = new Thread(new Person("第" + i + "个人", wc));
            t.start();
            Thread.sleep(new Random().nextInt(300));
        }
    }

    static class Person implements Runnable {
        private String name;
        private Semaphore wc;

        public Person(String name, Semaphore wc) {
            this.name = name;
            this.wc = wc;
        }

        @Override
        public void run() {
            System.out.print(name + "：憋死老子了!");
            if (wc.availablePermits() > 0) {
                System.out.println("天助我也，有坑位！");
            } else {
                System.out.println("卧槽，没坑位了，等会儿吧...");
            }
            try {
                wc.acquire(); //申请坑位
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + "：终于轮到我了，拉屎就是爽！");
            try {
                Thread.sleep(new Random().nextInt(1000)); // 模拟上厕所时间。
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + "：拉完了，好臭!");
            wc.release();
        }
    }
}
