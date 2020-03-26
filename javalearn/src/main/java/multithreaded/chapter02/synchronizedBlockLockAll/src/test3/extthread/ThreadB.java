package multithreaded.chapter02.synchronizedBlockLockAll.src.test3.extthread;

import multithreaded.chapter02.synchronizedBlockLockAll.src.test2.extobject.MyObject;

public class ThreadB extends Thread {
	private MyObject object;

	public ThreadB(MyObject object) {
		super();
		this.object = object;
	}

	@Override
	public void run() {
		super.run();
		object.speedPrintString();
	}
}
