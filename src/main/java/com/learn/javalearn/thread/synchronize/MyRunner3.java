package thread.synchronize;

/**
 * Created by Administrator on 2017/2/23.
 */
public class MyRunner3 implements Runnable {

    public ThreadLocal<Integer> tl = new ThreadLocal<Integer>();
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start.");
        for (int i = 0; i <= 100; i++) {
            if (tl.get() == null) {//get()返回此线程局部变量的当前线程副本中的值。
                tl.set(new Integer(0));
            }
            int sum = ((Integer) tl.get()).intValue();
            sum += i;
            tl.set(new Integer(sum));//set()将此线程局部变量的当前线程副本中的值设置为指定值。
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " --- The value of sum is " + ((Integer) tl.get()).intValue());
        System.out.println(Thread.currentThread().getName() + " End.");
    }
}



