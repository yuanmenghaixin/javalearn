package thread.returnValue.Callable.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch 多线程实现累加
 * Created by Peng.lv on 2017/11/1.
 */
public class CountDownLatchDemo {
    private CountDownLatch countDownLatch;
    private int start=10;
    private int mid=100;
    private int end =200;

    private volatile int tmpRes1, tmpRes2;

    private int add(int start,int end){
        int sum=0;
        for(int i=start;i<=end;i++){
            sum+=i;
        }
        return sum;
    }

    private int sum(int a, int b){
        return a+b;
    }

    public void calculate(){
        countDownLatch= new CountDownLatch(2);
        Thread thread1 =new Thread("线程1"){
            @Override
            public void run() {
                try{
                    Thread.sleep(100);
                    //确保线程3先与1，2执行，由于countDownLatch计数不为0而阻塞
                    System.out.println(Thread.currentThread().getName()+":开始执行");
                    tmpRes1=add(start,mid);
                    System.out.println(Thread.currentThread().getName()+":calculate ans:"+tmpRes1);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally {
                    //需要同步的线程执行完之后，计数-1
                    //必须有线程中显示的调用了countDown()计数-1方法；必须有线程显示调用了await()方法（没有这个就没有必要使用CountDownLatch了）
                    countDownLatch.countDown();
                }
            };
        };

        Thread thread2 =new Thread("线程2"){
            @Override
            public void run() {
                try{
                    Thread.sleep(100);
                    //确保线程3先与1，2执行，由于countDownLatch计数不为0而阻塞
                    System.out.println(Thread.currentThread().getName()+":开始执行");
                    tmpRes2=add(mid+1,end);
                    System.out.println(Thread.currentThread().getName()+":calculate ans:"+tmpRes2);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally {
                    //需要同步的线程执行完之后，计数-1
                    countDownLatch.countDown();
                }
            };
        };

        Thread thread3 =new Thread("线程3"){
            @Override
            public void run() {
                try{
                    System.out.println(Thread.currentThread().getName()+":开始执行");
                    //需要等待其他线程执行完毕之后，再运行的线程，调用countDown.await()实现阻塞同步
                    //必须有线程中显示的调用了countDown()计数-1方法；必须有线程显示调用了await()方法（没有这个就没有必要使用CountDownLatch了）
                    //由于await()方法会阻塞到计数为0，如果在代码逻辑中某个线程漏掉了计数-1，导致最终计数一直大于0，直接导致死锁了
                    //鉴于上面一点，更多的推荐await(long, TimeUnit)来替代直接使用await()方法，至少不会造成阻塞死只能重启的情况
                    countDownLatch.await();
                    int ans=sum(tmpRes1,tmpRes2);
                    System.out.println(Thread.currentThread().getName()+":calculate ans:"+ans);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            };
        };
        thread3.start();
        thread1.start();
        thread2.start();
    }

    public static void main(String[] args)throws InterruptedException{
        CountDownLatchDemo demo= new CountDownLatchDemo();
        demo.calculate();
        Thread.sleep(1000);
    }
}
