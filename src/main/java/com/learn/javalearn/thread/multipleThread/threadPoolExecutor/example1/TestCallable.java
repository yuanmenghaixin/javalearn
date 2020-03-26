package thread.multipleThread.threadPoolExecutor.example1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class TestCallable {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        List<Callable<List<String>>> tasks = new ArrayList<Callable<List<String>>>();
        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            Callable<List<String>> task = new Callable<List<String>>() {
                public List<String> call() throws Exception {
                    return Arrays.asList(UUID.randomUUID().toString());
                }
            };
            tasks.add(task);
        }

        List<String> finalResults = new ArrayList<String>(10);
        List<Future<List<String>>> results = ThreadPool.getThreadPool().invokeAll(tasks);
        List<String> finalResults2 = new ArrayList<String>(10);
        List<Future<List<String>>> results2 = ThreadPool.getThreadPool().invokeAll(tasks);
        List<String> finalResults3 = new ArrayList<String>(10);
        List<Future<List<String>>> results3 = ThreadPool.getThreadPool().invokeAll(tasks);
        for(Future<List<String>> ele : results) {
            List<String> list = ele.get();
            finalResults.addAll(list);
        }
        System.out.println(finalResults);
        for(Future<List<String>> ele : results2) {
            List<String> list = ele.get();
            finalResults2.addAll(list);
        }
        System.out.println(finalResults2);
        for(Future<List<String>> ele : results3) {
            List<String> list = ele.get();
            finalResults3.addAll(list);
        }
        System.out.println(finalResults3);
        ThreadPool.shutdown();
    }
}