package thread.synchronize;

/**
 * Created by Administrator on 2017/2/23.
 */
class MyRunner2 implements Runnable {

    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start.");
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " --- The value of sum is " + sum);
        System.out.println(Thread.currentThread().getName() + " End.");
    }
}



