package thread.lock.conditionLock;

/**
 * Created by Peng.lv on 2017/11/17.
 */
public class ProducerConsumerSimulateConditionMain {
    public static void main(String[] arg) {
        ProducerConsumerSimulateCondition buffer = new ProducerConsumerSimulateCondition(10);
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);
        for (int i = 0; i < 50; i++) {
            new Thread(producer, "producer-" + i).start();
        }
        for (int i = 0; i < 50; i++) {
            new Thread(consumer, "consumer-" + i).start();
        }
        System.out.println("结束");
    }
}
