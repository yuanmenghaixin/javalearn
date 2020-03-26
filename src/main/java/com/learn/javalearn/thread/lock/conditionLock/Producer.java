package thread.lock.conditionLock;

/**
 * Created by Peng.lv on 2017/11/17.
 * 生产者
 */
public class Producer implements Runnable{
    private ProducerConsumer buffer;
    Producer(ProducerConsumer b){
        buffer=b;
    }
    @Override
    public void run() {
        while(true){
            buffer.put();
        }
    }
}
