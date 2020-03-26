package thread.returnValue;

import java.util.concurrent.*;

/**
 * 使用jdk 自带线程池结果管理器：ExecutorCompletionService。它将BlockingQueue 和Executor 封装起来。然后使用ExecutorCompletionService.submit()方法提交任务。
 * Created by Peng.lv on 2017/11/21.
 */
public class ExecutorCompletionServiceTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int num = 9;
        ExecutorCompletionService<String> executorCompletionService = new ExecutorCompletionService<String>(MyThreadPool.getExecutor());
        for(int i=0;i<=num;i++){
            Thread.sleep(100l);
            executorCompletionService.submit(new Task(i));
        }
        for(int i=0;i<=num;i++){
            System.out.println(executorCompletionService.take().get());
        }
        MyThreadPool.getExecutor().shutdown();
    }
    static class MyThreadPool{
        private static class exe{
            private static ExecutorService executor = Executors.newCachedThreadPool();
        }

        private MyThreadPool(){}

        public static  ExecutorService getExecutor(){
            return exe.executor;
        }
    }

    static class Task implements Callable<String>{
        private volatile int i;
        Task(int i){
            this.i = i;
        }
        public String call() throws Exception {
            Thread.sleep(1000l);
            return Thread.currentThread().getName() + "任务 :" +i;
        }

    }
}
