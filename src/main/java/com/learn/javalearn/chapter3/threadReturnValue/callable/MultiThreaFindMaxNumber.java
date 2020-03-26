package networkCode.chapter3.threadReturnValue.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Administrator on 2017/3/6.
 */
public class MultiThreaFindMaxNumber {
    public static int max(int[] data) {
        if (data.length == 1) {
            return data[0];
        } else if (data.length == 0) {
            throw new IllegalArgumentException();
        }
        //将任务分成两部分
        FindMaxNumber task1 = new FindMaxNumber(data, 0, data.length / 2);
        FindMaxNumber task2 = new FindMaxNumber(data, data.length / 2, data.length);
        //创建两个线程
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<Integer> future1 = service.submit(task1);
        Future<Integer> future2 = service.submit(task2);
        try {
            return Math.max(future1.get(), future2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
            return 0;
        } catch (ExecutionException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
