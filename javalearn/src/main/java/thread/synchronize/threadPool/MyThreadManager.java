package thread.synchronize.threadPool;

/**
 * 我们需要定义一个线程管理器，它用来对线程池中的线程进行管理
 */

public class MyThreadManager {
    public static void manageThread(MyThread[] threads, ThreadTask task) {
        for (int i = 0; i < threads.length; i++) {
            synchronized (threads[i]) {
                manageThread(threads[i], task);
            }
        }
        System.out.println(getThreadStatus(threads));
    }

    public static void manageThread(MyThread thread, ThreadTask task) {
        if (task == ThreadTask.Start) {
            if (thread.status == ThreadStatus.Running) {
                return;
            }
            if (thread.status == ThreadStatus.Stopped) {
                thread = new MyThread();
            }
            thread.status = ThreadStatus.Running;
            thread.start();

        } else if (task == ThreadTask.Stop) {
            if (thread.status != ThreadStatus.Stopped) {
                thread.interrupt();
                thread.status = ThreadStatus.Stopped;
            }
        } else if (task == ThreadTask.Sleep) {
            thread.status = ThreadStatus.Sleeping;
        } else if (task == ThreadTask.Wakeup) {
            thread.notify();
            thread.status = ThreadStatus.Running;
        }
    }

    public static String getThreadStatus(MyThread[] threads) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < threads.length; i++) {
            sb.append(threads[i].getName() + "的状态：" + threads[i].status).append("\r\n");
        }
        return sb.toString();
    }
}
