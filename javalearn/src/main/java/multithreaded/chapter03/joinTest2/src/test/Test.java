package multithreaded.chapter03.joinTest2.src.test;

import multithreaded.chapter03.isaliveFALSE.src.extthread.MyThread;

public class Test {

	public static void main(String[] args) {
		try {
			MyThread threadTest = new MyThread();
			threadTest.start();
			threadTest.join();

			System.out.println("���뵱threadTest����ִ����Ϻ�����ִ�У���������");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
