package multithreaded.chapter02.synchronizedBlockLockAll.src.test1.run;

import multithreaded.chapter02.synchronizedBlockLockAll.src.test1.extobject.MyObject;
import multithreaded.chapter02.synchronizedBlockLockAll.src.test1.extthread.ThreadA;
import multithreaded.chapter02.synchronizedBlockLockAll.src.test1.extthread.ThreadB;
import multithreaded.chapter02.synchronizedBlockLockAll.src.test1.service.Service;

public class Run1_2 {

	public static void main(String[] args) {
		Service service = new Service();
		MyObject object1 = new MyObject();
		MyObject object2 = new MyObject();

		ThreadA a = new ThreadA(service, object1);
		a.setName("a");
		a.start();

		ThreadB b = new ThreadB(service, object2);
		b.setName("b");
		b.start();
	}

}
