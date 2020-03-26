package thread.lock.conditionLock;

/**
 * Created by Peng.lv on 2017/11/17.
 * 用线程模拟生产者消费者
 */
public class ProducerConsumerSimulateMain {
    public static void main(String[] arg){
        final ProducerConsumerSimulate buffer=new ProducerConsumerSimulate(10);
        Producer producer=new Producer(buffer);
        Consumer consumer=new Consumer(buffer);
        //创建线程执行生产和消费
       for(int i=0;i<100;i++){
            new Thread(producer,"producer----"+i).start();
        }
        for(int i=0;i<50;i++){
            new Thread(consumer,"consumer----"+i).start();
        }
       /* for(int i=0;i<100;i++){
            final int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    buffer.putNum(finalI);
                }
            },"producer----"+i).start();

        }
        for(int i=0;i<100;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    buffer.takeNum();
                }
            },"consumer----"+i).start();
        }*/
    }
}
