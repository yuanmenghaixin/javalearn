package thread.executor.example1;

/**
 * Created by Peng.lv on 2018/5/17.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ConcurrentCalculator {

    private ExecutorService exec;
    private int cpuCoreNumber;
    private List<Future<Long>> tasks = new ArrayList<Future<Long>>();

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

    public ConcurrentCalculator() {
        cpuCoreNumber = Runtime.getRuntime().availableProcessors();
        exec = Executors.newFixedThreadPool(cpuCoreNumber);//ExecutorService exec
    }

    public Long sum(final int[] numbers) {
        long startTime=System.currentTimeMillis();
        // 根据CPU核心个数拆分任务，创建FutureTask并提交到Executor
        for (int i = 0; i < cpuCoreNumber; i++) {
            int increment = numbers.length / cpuCoreNumber + 1;
            int start = increment * i;
            int end = increment * i + increment;
            if (end > numbers.length) {
                end = numbers.length;
            }
            SumCalculator subCalc = new SumCalculator(numbers, start, end);
            FutureTask<Long> task = new FutureTask<Long>(subCalc);
            tasks.add(task);
            if (!exec.isShutdown()) {
                exec.submit(task);
            }
        }
        // 根据CPU核心个数拆分任务，创建FutureTask并提交到Executor
        for (int i = 0; i < cpuCoreNumber; i++) {
            int increment = numbers.length / cpuCoreNumber + 1;
            int start = increment * i;
            int end = increment * i + increment;
            if (end > numbers.length) {
                end = numbers.length;
            }
            SumCalculator subCalc = new SumCalculator(numbers, start, end);
            FutureTask<Long> task = new FutureTask<Long>(subCalc);
            tasks.add(task);
            if (!exec.isShutdown()) {
                exec.submit(task);
            }
        }
        return getResult(startTime);

    }

    /**
     * 迭代每个只任务，获得部分和，相加返回
     *
     * @return
     */
    public Long getResult(long startTime) {
        Long result = 0L;
        for (Future<Long> task : tasks) {
            try {
                // 如果计算未完成则阻塞
                Long subSum = task.get();
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
        ConcurrentCalculator calc = new ConcurrentCalculator();
        Long sum = calc.sum(numbers);
        System.out.println(sum);
        calc.close();
    }
}
