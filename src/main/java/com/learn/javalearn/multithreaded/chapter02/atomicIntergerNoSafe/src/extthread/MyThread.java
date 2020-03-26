package multithreaded.chapter02.atomicIntergerNoSafe.src.extthread;

import multithreaded.chapter02.atomicIntergerNoSafe.src.service.MyService;

public class MyThread extends Thread {
	private MyService mySerivce;

	public MyThread(MyService mySerivce) {
		super();
		this.mySerivce = mySerivce;
	}

	@Override
	public void run() {
		mySerivce.addNum();
	}

}
