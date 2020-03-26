package multithreaded.chapter04.ReadWriteLockBegin3.src.test;

import multithreaded.chapter04.ReadWriteLockBegin1.src.service.Service;
import multithreaded.chapter04.MustUseMoreCondition_Error.src.extthread.ThreadA;
import multithreaded.chapter04.MustUseMoreCondition_Error.src.extthread.ThreadB;

public class Run {

	public static void main(String[] args) throws InterruptedException {

		Service service = new Service();

		ThreadA a = new ThreadA(service);
		a.setName("A");
		a.start();

		Thread.sleep(1000);

		ThreadB b = new ThreadB(service);
		b.setName("B");
		b.start();

	}

}
