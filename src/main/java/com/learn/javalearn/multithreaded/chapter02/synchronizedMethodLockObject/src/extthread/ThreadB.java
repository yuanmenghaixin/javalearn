package multithreaded.chapter02.synchronizedMethodLockObject.src.extthread;

import multithreaded.chapter02.synchronizedMethodLockObject.src.extobject.MyObject;

public class ThreadB extends Thread {

	private MyObject object;

	public ThreadB(MyObject object) {
		super();
		this.object = object;
	}

	@Override
	public void run() {
		super.run();
		object.methodA();
	}
}
