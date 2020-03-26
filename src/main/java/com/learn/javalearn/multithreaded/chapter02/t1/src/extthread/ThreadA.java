package multithreaded.chapter02.t1.src.extthread;

import multithreaded.chapter02.t1.src.service.HasSelfPrivateNum;

public class ThreadA extends Thread {

	private HasSelfPrivateNum numRef;

	public ThreadA(HasSelfPrivateNum numRef) {
		super();
		this.numRef = numRef;
	}

	@Override
	public void run() {
		super.run();
		numRef.addI("a");
	}

}
