package multithreaded.chapter02.t3.src.extthread;

import multithreaded.chapter02.t3.src.entity.PublicVar;

public class ThreadA extends Thread {

	private PublicVar publicVar;

	public ThreadA(PublicVar publicVar) {
		super();
		this.publicVar = publicVar;
	}

	@Override
	public void run() {
		super.run();
		publicVar.setValue("B", "BB");
	}
}
