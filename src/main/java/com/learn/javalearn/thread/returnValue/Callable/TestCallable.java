package thread.returnValue.Callable;

import java.util.concurrent.Callable;

/**
 * 实现Callable接口，定义可返回结果的线程任务
 */
public class TestCallable implements Callable<String> {
    private String id;

    public TestCallable(String id) {
        this.id = id;
    }

    public String call() throws Exception {
        return id + "返回结果";
    }
}
