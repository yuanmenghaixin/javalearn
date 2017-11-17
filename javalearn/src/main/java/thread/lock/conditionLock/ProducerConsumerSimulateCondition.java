package thread.lock.conditionLock;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 使用lock/condition实现生产者消费者模式如下：
 * Created by Peng.lv on 2017/11/17.
 */
public class ProducerConsumerSimulateCondition implements ProducerConsumer{
    private  final Lock lock;
    private  final Condition notFull;
    private  final Condition notEmpty;
    private int maxSize;
    private List<Date> storage;
    ProducerConsumerSimulateCondition(int size){
        //使用锁lock，并且创建两个condition，相当于两个阻塞队列
        lock=new ReentrantLock();
        notFull=lock.newCondition();
        notEmpty=lock.newCondition();
        maxSize=size;
        storage=new LinkedList<>();
    }
    @Override
    public void put()  {
        lock.lock();
        try {
            while (storage.size() ==maxSize ){//如果队列满了
                System.out.print(Thread.currentThread().getName()+": wait \n");;
                notFull.await();//阻塞生产线程
            }
            storage.add(new Date());
            System.out.print(Thread.currentThread().getName()+": put:"+storage.size()+ "\n");
            Thread.sleep(10);
            notEmpty.signalAll();//唤醒消费线程
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    @Override
    public  void take() {
        lock.lock();
        try {
            while (storage.size() ==0 ){//如果队列满了
                System.out.print(Thread.currentThread().getName()+": wait \n");;
                notEmpty.await();//阻塞消费线程
            }
            Date d=((LinkedList<Date>)storage).poll();
            System.out.print(Thread.currentThread().getName()+": take:"+storage.size()+ "\n");
            Thread.sleep(10);
            notFull.signalAll();//唤醒生产线程

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
}
