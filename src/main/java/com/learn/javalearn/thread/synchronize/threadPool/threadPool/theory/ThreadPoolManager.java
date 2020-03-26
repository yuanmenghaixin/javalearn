package thread.synchronize.threadPool.threadPool.theory;

import java.util.ArrayList;

/**
 * 线程池的简单实现
 *一般一个简单线程池至少包含下列组成部分。
 *1. 线程池管理器（ThreadPoolManager）：用于创建并管理线程池
 *2. 工作线程（WorkThread）: 线程池中线程
 *3. 任务接口（Task）:每个任务必须实现的接口，以供工作线程调度任务的执行。
 *4. 任务队列:用于存放没有处理的任务。提供一种缓冲机制。
 *线程池管理器至少有下列功能：创建线程池，销毁线程池，添加新任务 创建线程池的部分代码如下：
 * Created by Peng.lv on 2017/10/13.
 */
public class ThreadPoolManager {

    private int threadCount; //启动的线程数

    private WorkThread[] handlers; //线程数组

    private ArrayList<Runnable> taskVector = new ArrayList<Runnable>(); //任务队列

    ThreadPoolManager(int threadCount) {
        this.threadCount = threadCount;
        for (int i = 0; i < threadCount; i++) {
            handlers[i] = new WorkThread();
            handlers[i].start();
        }
    }

    void shutdown() {
        synchronized (taskVector) {
            while (!taskVector.isEmpty())
                taskVector.remove(0); //清空任务队列

        }
        for (int i = 0; i < threadCount; i++) {
            handlers[i] = new WorkThread();
            handlers[i].interrupt(); //结束线程
        }
    }

    void execute(Runnable newTask) { //增加新任务
        synchronized (taskVector) {
            taskVector.add(newTask);
            taskVector.notifyAll();
        }
    }

    //工作线程（WorkThread）: 线程池中线程
    private class WorkThread extends Thread {
        public void run() {
            Runnable task = null;
            for (;;) {
                synchronized (taskVector) {//获取一个新任务
                    if (taskVector.isEmpty())
                        try {
                            taskVector.wait();
                            task = taskVector.remove(0);
                        } catch (InterruptedException e) {
                            break;
                        }
                }
                task.run();
            }
        }
    }

}