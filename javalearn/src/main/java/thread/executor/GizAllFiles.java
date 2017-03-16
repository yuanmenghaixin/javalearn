package thread.executor;


import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/3/7.
 */
public class GizAllFiles {
    private final static int THREAD_COUNT=4;
    public static void main(String[] args){
        ExecutorService pool =  Executors.newFixedThreadPool(THREAD_COUNT);
        for(String fileName:args){
            File f = new File(fileName);
            if(f.exists()){
                if(f.isDirectory()){
                    File[] files =f.listFiles();
                    for(File file:files){
                        if(!file.isDirectory()){//不递归处理
                            Runnable task=new GZipRunnable(file);
                            pool.submit(task);
                        }

                    }
                }else{
                    Runnable task=new GZipRunnable(f);
                    pool.submit(task);
                }
            }
        }
        pool.shutdown();
    }
}
