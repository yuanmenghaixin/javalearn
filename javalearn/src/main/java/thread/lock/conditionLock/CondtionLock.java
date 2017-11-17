package thread.lock.conditionLock;

import thread.returnValue.Callable.CountDownLatch.CountDownLatchDemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 在JDK的阻塞队列中，很多地方就利用了Condition和Lock来实现出队入队的并发安全性，以ArrayBlockingQueue为例
 * Created by Peng.lv on 2017/11/2.
 */
public class CondtionLock {
    private int start=10;
    private int middle=90;
    private int end =200;

    private volatile int tmpRes1=0, tmpRes2=0;
    private Lock lock= new ReentrantLock();
    private Condition condition=lock.newCondition();
    private AtomicInteger count = new AtomicInteger(0);

    private int add(int start,int end){
        try{
            lock.lock();
            int sum=0;
            for(int i=start;i<=end;i++){
                sum+=i;
            }
            return sum;
        }finally {
            atomic();
            lock.unlock();
        }
    }

    private int sum() throws InterruptedException {
        try{
            lock.lock();
            condition.await();
            return tmpRes1+tmpRes2;
        }finally {
            lock.unlock();
        }
    }

    private void atomic(){
        System.out.println("调用一次atomic");
        if(2==count.addAndGet(1)){//使用CAS
            System.out.println("condition等于2结束");
            condition.signal();

        }
    }

    public void calculate() throws InterruptedException {
        final CondtionLock condtionLock= new CondtionLock();
        Thread thread1 =new Thread("线程count1"){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+":开始执行");
                condtionLock.tmpRes1=condtionLock.add(condtionLock.start,condtionLock.middle);
                System.out.println(Thread.currentThread().getName()+":calculate ans:"+ condtionLock.tmpRes1);
            };
        };

        Thread thread2 =new Thread("线程count2"){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+":开始执行");
                condtionLock.tmpRes2=condtionLock.add(condtionLock.middle,condtionLock.end+1);
                System.out.println(Thread.currentThread().getName()+":calculate ans:"+ condtionLock.tmpRes2);
            };
        };

        Thread thread3 =new Thread("线程sum"){
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName()+":开始执行");
                    int ans=condtionLock.sum();
                    System.out.println(Thread.currentThread().getName()+":the total result:"+ ans);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        };
        thread3.start();
        thread1.start();
        thread2.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("over");
    }

    public static void main(String[] args)throws InterruptedException{
        CondtionLock demo= new CondtionLock();
        demo.calculate();
    }
}
