package thread.lock;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class ReadWriteLockTest {
	 /**
     * һ���������д��
     */
    private ReentrantReadWriteLock readWriteLock =new ReentrantReadWriteLock();
    /**
     * ����
     */
    private ReadLock readLock =readWriteLock.readLock();
    /**
     * д��
     */
    private WriteLock writeLock =readWriteLock.writeLock();
    /**
     * ������Դ
     */
    private String shareData ="��į�ȴ���...";
   
    public void write(String str) throws InterruptedException {
          
     writeLock.lock();
           System.err.println("ThreadName:"+Thread.currentThread().getName()+"locking...");
           try {
                  shareData = str;
                  System.err.println("ThreadName:" + Thread.currentThread().getName()+"�޸�Ϊ"+str);
                  Thread.sleep(20);
           }catch(InterruptedException e) {
                  e.printStackTrace();
           }finally {
                  System.err.println("ThreadName:" + Thread.currentThread().getName()+"  unlock...");
                  writeLock.unlock();
           }
    }
   
    public String read() {
          
           readLock.lock();
           System.out.println("ThreadName:" + Thread.currentThread().getName()+"lock...");
           try {
                  System.out.println("ThreadName:"+Thread.currentThread().getName()+"��ȡΪ��"+shareData);
                  Thread.sleep(1);
           }catch(InterruptedException e) {
                  e.printStackTrace();
           }finally {
                  System.out.println("ThreadName:" + Thread.currentThread().getName()+"unlock...");
                  readLock.unlock();
           }
           return shareData;
    }
   
    public static void main(String[] args) {
           final ReadWriteLockTest shareData =new ReadWriteLockTest();
           /**
            * ��50�����߳�
            */
           for(int i = 0; i < 50; i++) {
                  new Thread(new Runnable() {
                         public void run() {
                                       try {
                                              Thread.sleep(1);
                                       }catch (InterruptedException e) {
                                              e.printStackTrace();
                                       }
                                       shareData.read();
                                }
                  },"get Thread-read"+i).start();
           }
          
           for(int i = 0; i < 5; i++) {
                  new Thread(new Runnable() {
                         public void run() {
                                try {
                                       Thread.sleep(1);
                                }catch (InterruptedException e1) {
                                       e1.printStackTrace();
                                }
                                try {
                                       shareData.write(new Random().nextLong()+"");
                                }catch (InterruptedException e) {
                                       e.printStackTrace();
                                }
                         }
                  },"wirte Thread-write"+i).start();
           }
    }
}
