package thread.synchronize.threadPool;

/**
 * Created by Administrator on 2017/2/23.
 */
public class MyThread extends Thread {
    public ThreadStatus status = ThreadStatus.Initial;
    public ThreadTask task;

    public void run() {
        status = ThreadStatus.Running;
        while (true) {
            try {
                Thread.sleep(3000);
                if (status == ThreadStatus.Sleeping) {
                    System.out.println(Thread.currentThread().getName() + " 进入休眠状态。");
                    this.wait();
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " 运行过程中出现错误。");
                status = ThreadStatus.Stopped;
            }
        }
    }
}

