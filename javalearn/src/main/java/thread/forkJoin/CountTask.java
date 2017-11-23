package thread.forkJoin;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;
/**
 * Fork/Join框架是Java7提供了的一个用于并行执行任务的框架， 是一个把大任务分割成若干个小任务，最终汇总每个小任务结果后得到大任务结果的框架
 * Created by Peng.lv on 2017/11/22.
 */
public class CountTask extends RecursiveTask {
    private static final int THRESHOLD= 2;//阈值
    private int start;
    private int end;
    public CountTask(int start,int end) {
        this.start= start;
        this.end= end;
    }

    //通过这个例子让我们再来进一步了解ForkJoinTask，ForkJoinTask与一般的任务的主要区别在于它需要实现compute方法，
    // 在这个方法里，首先需要判断任务是否足够小，如果足够小就直接执行任务。如果不足够小，就必须分割成两个子任务，每个子任务在调用fork方法时，又会进入compute方法，
    // 看看当前子任务是否需要继续分割成孙任务，如果不需要继续分割，则执行当前子任务并返回结果。使用join方法会等待子任务执行完并得到其结果。
    @Override
    protected Integer compute() {
        int sum = 0;
        //如果任务足够小就计算任务
        boolean canCompute = (end-start) <=THRESHOLD;
        if(canCompute) {
            for(int i =start; i <=end; i++) {
                sum += i;
            }
        }else{
            //如果任务大于阀值，就分裂成两个子任务计算
            int middle = (start+end) / 2;
            CountTask leftTask =new CountTask(start, middle);
            CountTask rightTask =new CountTask(middle + 1,end);
            //执行子任务
            leftTask.fork();
            rightTask.fork();
            //等待子任务执行完，并得到其结果
            int leftResult= (int) leftTask.join();
            int rightResult= (int) rightTask.join();
            //合并子任务
            sum = leftResult  + rightResult;
        }
        return sum;
    }



    public static void main(String[] args) {
        ForkJoinPool forkJoinPool =new ForkJoinPool();
        //生成一个计算任务，负责计算1+2+3+4
        CountTask task =new CountTask(1, 4);
        //执行一个任务
        Future result = forkJoinPool.submit(task);
        try{
            System.out.println(result.get());
        }catch(InterruptedException e) {
        }catch(ExecutionException e) {
        }
    }

}
