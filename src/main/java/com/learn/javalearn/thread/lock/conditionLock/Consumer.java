package thread.lock.conditionLock;

/**
 * 消费者
 * Created by Peng.lv on 2017/11/17.
 */
public class Consumer implements Runnable{
    private ProducerConsumer buffer;
    Consumer(ProducerConsumer b){
        buffer=b;
    }
    @Override
    public void run() {
        while(true){
            buffer.take();
        }
    }
}
