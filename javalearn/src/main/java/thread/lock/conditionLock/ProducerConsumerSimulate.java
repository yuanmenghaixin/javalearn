package thread.lock.conditionLock;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * 使用synchronized/wait()/notifyAll实现生产者消费者模式如下：
 * Created by Peng.lv on 2017/11/17.
 */
public class ProducerConsumerSimulate implements ProducerConsumer{
    private int maxSize;
    private List<Date> storage;
    private List<Integer> storageInteger;
    ProducerConsumerSimulate(int size){
        maxSize=size;
        storage=new LinkedList<Date>();
        storageInteger=new LinkedList<Integer>();
    }
    //生产方法
    @Override
    public synchronized void put()  {
        try {
            while (storage.size() ==maxSize ){//如果队列满了
                System.out.print(Thread.currentThread().getName()+": wait \n");;
                wait();//阻塞线程
            }
            storage.add(new Date());
            System.out.print(Thread.currentThread().getName()+": put:"+storage.size()+ "\n");
            Thread.sleep(10);
            notifyAll();//唤起线程
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("生产者方法线程打断异常");
        }
    }
    //消费方法
    @Override
    public synchronized void take() {
        try {
            while (storage.size() ==0 ){//如果队列满了
                System.out.print(Thread.currentThread().getName()+": wait \n");;
                wait();//阻塞线程
            }
            Date d=((LinkedList<Date>)storage).poll();
            System.out.print(Thread.currentThread().getName()+": take:"+storage.size()+ "\n");
            Thread.sleep(10);
            notifyAll();//唤起线程
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("消费者方法线程打断异常");
        }
    }

    public synchronized void putNum(int putNum)  {
        try {
            while (storageInteger.size() ==maxSize ){//如果队列满了
                System.out.print(Thread.currentThread().getName()+": wait \n");;
                wait();//阻塞线程
            }
            storageInteger.add(putNum);
            System.out.print(Thread.currentThread().getName()+": put:"+putNum+ "\n");
            Thread.sleep(10);
            notifyAll();//唤起线程
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("生产者方法线程打断异常");
        }
    }
    //消费方法
    public synchronized void takeNum() {
        try {
            while (storageInteger.size() ==0 ){//如果队列满了
                System.out.print(Thread.currentThread().getName()+": wait \n");;
                wait();//阻塞线程
            }
            Integer getNum=((LinkedList<Integer>)storageInteger).poll();
            System.out.print(Thread.currentThread().getName()+": take:"+getNum+ "\n");
            Thread.sleep(10);
            notifyAll();//唤起线程
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("消费者方法线程打断异常");
        }
    }
}
