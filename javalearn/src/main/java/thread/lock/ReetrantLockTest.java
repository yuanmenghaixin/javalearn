package thread.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReetrantLockTest {

	/**
	 * һ������������Ա����
	 */
	private ReentrantLock lock = new ReentrantLock();

	public static void main(String[] args) {
		ReetrantLockTest dalt = new ReetrantLockTest();
		dalt.testLock();
	}

	public void testLock() {
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(new Runnable() {
				public void run() {
					sayHello();
				}
			}, "thread" + i);
			thread.start();
		}
	}

	public void sayHello() {
		/**
		 * ��һ���̲߳��ͷ�����ʱ�򣬵ڶ����߳��ߵ������ʱ�����������
		 */
		try {
			lock.lock();
			System.out.println(Thread.currentThread().getName() + " locking ...");
			System.out.println("Hello world!");
			System.out.println(Thread.currentThread().getName() + " unlocking ...");
		} finally {
			lock.unlock();
		}
	}

}
