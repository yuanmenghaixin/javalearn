package thread.concurrent;

/**
 * Created by Administrator on 2017/2/23.
 */
public class MyRunner implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "运行开始"+System.currentTimeMillis());
        for (int i = 0; i < 2; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + "正在运行");
                Thread.sleep(200);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }
}
