package multithreaded.chapter04.ReadWriteLockBegin4.src.test;

import multithreaded.chapter04.ReadWriteLockBegin1.src.service.Service;
import multithreaded.chapter04.MustUseMoreCondition_Error.src.extthread.ThreadA;
import multithreaded.chapter04.MustUseMoreCondition_Error.src.extthread.ThreadB;

public class Run {

	public static void main(String[] args) throws InterruptedException {

		Service service = new Service();

		ThreadB b = new ThreadB(service);
		b.setName("B");
		b.start();

		Thread.sleep(1000);

		ThreadA a = new ThreadA(service);
		a.setName("A");
		a.start();

	}

}
