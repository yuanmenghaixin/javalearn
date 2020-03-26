package thread.returnValue.Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * FutureTask是Future和Callable的结合体。传统的代码是这样写的
 * Future f = executor.submit(new Callable());
 * 然后通过Future来取得计算结果。但是，若开启了多个任务，我们无从知晓哪个任务最先结束，因此，若要实现“当某任务结束时，立刻做一些事情，例如记录日志”这一功能，就需要写一些额外的代码。
 * FutureTask正是为此而存在，他有一个回调函数protected void done()，当任务结束时，该回调函数会被触发。因此，只需重载该函数，即可实现在线程刚结束时就做一些事情。
 * Created by Peng.lv on 2017/6/16.
 */
public class FutureTaskMain {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for(int i=0; i<5; i++) {
            Callable<String> task = new TestCallable("Callable和FutureTask结合返回线程结果的学习");
            MyFutureTask ft = new MyFutureTask(task);
            executor.submit(ft);
        }
        executor.shutdown();
    }
}
