package thread.returnValue.Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by Peng.lv on 2017/6/16.
 */
public class MyFutureTask extends FutureTask<String> {

    public MyFutureTask(Callable<String> callable) {
        super(callable);
    }

    @Override
    protected void done() {
        try {
            System.out.println(get() + " 线程执行完毕！~");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
