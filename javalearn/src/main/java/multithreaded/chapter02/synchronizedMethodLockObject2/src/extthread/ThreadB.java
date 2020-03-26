package multithreaded.chapter02.synchronizedMethodLockObject2.src.extthread;

import multithreaded.chapter02.synchronizedMethodLockObject2.src.extobject.MyObject;

public class ThreadB extends Thread {

	private MyObject object;

	public ThreadB(MyObject object) {
		super();
		this.object = object;
	}

	@Override
	public void run() {
		super.run();
		object.methodB();
	}
}
