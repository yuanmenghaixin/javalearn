package thread.executor.example1;

/**
 * Created by Peng.lv on 2018/5/17.
 * CompletionService
 在刚在的例子中，getResult()方法的实现过程中，迭代了FutureTask的数组，如果任务还没有完成则当前线程会阻塞，
 如果我们希望任意字任务完成后就把其结果加到result中，而不用依次等待每个任务完成，可以使CompletionService。
 生产者submit()执行的任务。使用者take()已完成的任务，并按照完成这些任务的顺序处理它们的结果 。
 也就是调用CompletionService的take方法是，会返回按完成顺序放回任务的结果，CompletionService内部维护了一个阻塞队列BlockingQueue，
 如果没有任务完成，take()方法也会阻塞。修改刚才的例子使用CompletionService：
 */

import java.util.concurrent.*;

public class ConcurrentCalculator2 {

    private ExecutorService exec;
    private int cpuCoreNumber;
    private CompletionService<Long> completionService;

    // 内部类
    class SumCalculator implements Callable<Long> {
        private int[] numbers;
        private int start;
        private int end;

        public SumCalculator(final int[] numbers, int start, int end) {
            this.numbers = numbers;
            this.start = start;
            this.end = end;
        }

        @Override
        public Long call() throws Exception {
            Long sum = 0L;
            for (int i = start; i < end; i++) {
                sum += numbers[i];
            }
            return sum;
        }
    }

    public ConcurrentCalculator2() {
        cpuCoreNumber = Runtime.getRuntime().availableProcessors();
        exec = Executors.newFixedThreadPool(cpuCoreNumber);//ExecutorService exec;
        completionService = new ExecutorCompletionService<Long>(exec);//CompletionService<Long> completionService;
    }

    public Long sum(final int[] numbers) {
        long startTime=System.currentTimeMillis();
        // 根据CPU核心个数拆分任务，创建FutureTask并提交到Executor
        for (int i = 0; i < cpuCoreNumber; i++) {//计算第二遍
            int increment = numbers.length / cpuCoreNumber + 1;
            int start = increment * i;
            int end = increment * i + increment;
            if (end > numbers.length) {
                end = numbers.length;
            }
            SumCalculator subCalc = new SumCalculator(numbers, start, end);
            if (!exec.isShutdown()) {
                completionService.submit(subCalc);
            }

        }
        Long a=getResult(startTime);
        for (int i = 0; i < cpuCoreNumber; i++) {//计算第二遍
            int increment = numbers.length / cpuCoreNumber + 1;
            int start = increment * i;
            int end = increment * i + increment;
            if (end > numbers.length) {
                end = numbers.length;
            }
            SumCalculator subCalc = new SumCalculator(numbers, start, end);
            if (!exec.isShutdown()) {
                completionService.submit(subCalc);
            }

        }
         a=a+getResult(startTime);//两次结果求和
        return a;
    }

    /**
     * 迭代每个只任务，获得部分和，相加返回
     *
     * @return
     */
    public Long getResult(long startTime) {
        Long result = 0L;
        for (int i = 0; i < cpuCoreNumber; i++) {
            try {
                Long subSum = completionService.take().get();
                result += subSum;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        long end=System.currentTimeMillis();
        System.out.println("耗时间："+(end-startTime));
        return result;
    }

    public void close() {
        exec.shutdown();
    }

    public static void main(String[] args){
        int[] numbers = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 10, 11 };
        ConcurrentCalculator2 calc = new ConcurrentCalculator2();
        Long sum = calc.sum(numbers);
        System.out.println(sum);
        calc.close();
    }
}
