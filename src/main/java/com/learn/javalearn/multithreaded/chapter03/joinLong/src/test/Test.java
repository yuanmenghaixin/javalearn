package multithreaded.chapter03.joinLong.src.test;

import multithreaded.chapter03.isaliveFALSE.src.extthread.MyThread;

public class Test {

	public static void main(String[] args) {
		try {
			MyThread threadTest = new MyThread();
			threadTest.start();

			// threadTest.join(2000);// ֻ��2��
			Thread.sleep(2000);

			System.out.println("  end timer=" + System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
