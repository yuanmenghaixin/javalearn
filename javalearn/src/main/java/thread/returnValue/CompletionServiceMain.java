package thread.returnValue;

import java.util.concurrent.*;

/**
 * 使用jdk 自带线程池结果管理器：ExecutorCompletionService。它将BlockingQueue 和Executor 封装起来。然后使用ExecutorCompletionService.submit()方法提交任务。
 * Created by Administrator on 2017/2/23.
 */
public class CompletionServiceMain {
    //返回线程池中每个线程的结果
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        completionServiceTest();
    }
    private static void completionServiceTest() throws InterruptedException, ExecutionException {
        ExecutorService exec = Executors.newFixedThreadPool(10);
        CompletionService<String> service = new ExecutorCompletionService<String>(exec);
        for (int i = 0; i < 10; i++) {
            Callable<String> call = new Callable<String>() {
                @Override
                public String call() throws InterruptedException {
                    return Thread.currentThread().getName();
                }
            };
            service.submit(call);
        }
        Thread.sleep(1000);
        for (int i = 0; i < 10; i++) {
            Future<String> result = service.take();
            System.out.println("线程的返回值是" + result.get());
        }
        exec.shutdown();
    }


}
