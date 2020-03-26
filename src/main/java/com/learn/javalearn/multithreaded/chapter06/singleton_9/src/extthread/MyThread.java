package multithreaded.chapter06.singleton_9.src.extthread;

import multithreaded.chapter06.singleton_0.src.test.MyObject;

public class MyThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(MyObject.connectionFactory.getConnection()
					.hashCode());
		}
	}
}
