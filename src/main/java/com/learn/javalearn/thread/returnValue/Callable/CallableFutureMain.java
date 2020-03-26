package thread.returnValue.Callable;

import java.util.concurrent.*;

/**
 * 处理线程返回值
 * 　　在有些情况下，我们需要使用线程的返回值，在上述的所有代码中，线程这是执行了某些操作，没有任何返回值。
 * 　　如何做到这一点呢？我们可以使用JDK中的Callable<T>和CompletionService<T>，前者返回单个线程的结果，后者返回一组线程的结果。
 * 　　返回单个线程的结果
 * FutureTask是Future和Callable的结合体。传统的代码是这样写的
 * Future f = executor.submit(new Callable());
 */
public class CallableFutureMain {
    private static void callableTest() throws InterruptedException, ExecutionException {
        ExecutorService exec = Executors.newFixedThreadPool(1);
        Callable<String> call = new Callable<String>() {
            public String call() {
                return "Hello World.";
            }
        };
        Future<String> result = exec.submit(call);//提交一个返回值的任务用于执行，返回一个表示任务的未决结果的 Future
        System.out.println("线程的返回值是" + result.get());
        exec.shutdown();
    }

    //返回单个线程的结果
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        callableTest();
    }
}
