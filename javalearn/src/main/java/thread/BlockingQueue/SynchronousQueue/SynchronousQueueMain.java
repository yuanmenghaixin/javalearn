package thread.BlockingQueue.SynchronousQueue;

/**
 * Created by Peng.lv on 2017/6/22.
 * SynchronousQueue：一个不存储元素的阻塞队列。
 * SynchronousQueue是一个不存储元素的阻塞队列。每一个put操作必须等待一个take操作，否则不能继续添加元素。SynchronousQueue可以看成是一个传球手，负责把生产者线程处理的数据直接传递给消费者线程。队列本身并不存储任何元素，非常适合于传递性场景,比如在一个线程中使用的数据，传递给另外一个线程使用，SynchronousQueue的吞吐量高于LinkedBlockingQueue 和 ArrayBlockingQueue。
 */
public class SynchronousQueueMain {
}
