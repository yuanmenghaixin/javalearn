package thread.daemon;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 守护线程例子
 * Created by Peng.lv on 2017/11/23.
 */
public class DeamonMain {
    public static void main(String[] args) {
        Deque<Event> deque=new ArrayDeque<Event>();
        WriterTask writer=new WriterTask(deque);
        for (int i=0; i<3; i++){
            Thread thread=new Thread(writer);
            thread.start();
        }
        CleanerTask cleaner=new CleanerTask(deque);
        cleaner.start();
    }
}
