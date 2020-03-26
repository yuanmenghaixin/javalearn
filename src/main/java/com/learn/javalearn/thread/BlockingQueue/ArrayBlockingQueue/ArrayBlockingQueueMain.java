package thread.BlockingQueue.ArrayBlockingQueue;

/**
 * Created by Peng.lv on 2017/6/22.
 * ArrayBlockingQueue ：一个由数组结构组成的有界阻塞队列。
 * ArrayBlockingQueue是一个用数组实现的有界阻塞队列。此队列按照先进先出（FIFO）的原则对元素进行排序。默认情况下不保证访问者公平的访问队列，所谓公平访问队列是指阻塞的所有生产者线程或消费者线程，当队列可用时，可以按照阻塞的先后顺序访问队列，即先阻塞的生产者线程，可以先往队列里插入元素，先阻塞的消费者线程，可以先从队列里获取元素。通常情况下为了保证公平性会降低吞吐量。我们可以使用以下代码创建一个公平的阻塞队列：
 ArrayBlockingQueue fairQueue = new  ArrayBlockingQueue(1000,true);
 */
public class ArrayBlockingQueueMain {
}
