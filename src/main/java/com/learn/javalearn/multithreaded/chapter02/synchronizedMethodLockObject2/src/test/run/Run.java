package multithreaded.chapter02.synchronizedMethodLockObject2.src.test.run;

import multithreaded.chapter02.synchronizedMethodLockObject.src.extobject.MyObject;
import multithreaded.chapter02.synchronizedMethodLockObject.src.extthread.ThreadA;
import multithreaded.chapter02.synchronizedMethodLockObject.src.extthread.ThreadB;

public class Run {

	public static void main(String[] args) {
		MyObject object = new MyObject();
		ThreadA a = new ThreadA(object);
		a.setName("A");
		ThreadB b = new ThreadB(object);
		b.setName("B");

		a.start();
		b.start();
	}

}
