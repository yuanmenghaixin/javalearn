package multithreaded.chapter06.singleton_2.src.extthread;

import multithreaded.chapter06.singleton_0.src.test.MyObject;

public class MyThread extends Thread {

	@Override
	public void run() {
		System.out.println(MyObject.getInstance().hashCode());
	}

}
