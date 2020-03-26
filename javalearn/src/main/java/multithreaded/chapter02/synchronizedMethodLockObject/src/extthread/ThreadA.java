package multithreaded.chapter02.synchronizedMethodLockObject.src.extthread;

import multithreaded.chapter02.synchronizedMethodLockObject.src.extobject.MyObject;

public class ThreadA extends Thread {

	private MyObject object;

	public ThreadA(MyObject object) {
		super();
		this.object = object;
	}

	@Override
	public void run() {
		super.run();
		object.methodA();
	}

}
