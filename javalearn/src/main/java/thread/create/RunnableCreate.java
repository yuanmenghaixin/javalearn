package thread.create;

/**
 * 　第一是创建状态。在生成线程对象，并没有调用该对象的start方法，这是线程处于创建状态。
 　　第二是就绪状态。当调用了线程对象的start方法之后，该线程就进入了就绪状态，但是此时线程调度程序还没有把该线程设置为当前线程，此时处于就绪状态。在线程运行之后，从等待或者睡眠中回来之后，也会处于就绪状态。
 　　第三是运行状态。线程调度程序将处于就绪状态的线程设置为当前线程，此时线程就进入了运行状态，开始运行run函数当中的代码。
 　　第四是阻塞状态。线程正在运行的时候，被暂停，通常是为了等待某个时间的发生(比如说某项资源就绪)之后再继续运行。sleep,suspend，wait等方法都可以导致线程阻塞。
 　　第五是死亡状态。如果一个线程的run方法执行结束或者调用stop方法后，该线程就会死亡。对于已经死亡的线程，无法再使用start方法令其进入就绪。
 * Created by Peng.lv on 2017/11/23.
 */
public class RunnableCreate  implements Runnable{
    @Override
    public void run() {//线程体
        System.out.println("创建线程第二种方式：写一个类实现Runnable接口，实现run方法。用new Thread(Runnable target).start()方法来启动");
    }
    public static void main(String[] args){
        RunnableCreate  runnableCreate = new RunnableCreate();
       Thread thread= new Thread(runnableCreate);
        thread.start();
    }
}
