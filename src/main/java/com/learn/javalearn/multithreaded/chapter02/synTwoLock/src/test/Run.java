package multithreaded.chapter02.synTwoLock.src.test;

import multithreaded.chapter02.synTwoLock.src.service.Service;
import multithreaded.chapter02.synTwoLock.src.extthread.ThreadA;
import multithreaded.chapter02.synTwoLock.src.extthread.ThreadB;
import multithreaded.chapter02.synTwoLock.src.extthread.ThreadC;

public class Run {

	public static void main(String[] args) {

		Service service = new Service();

		ThreadA a = new ThreadA(service);
		a.setName("A");
		a.start();

		ThreadB b = new ThreadB(service);
		b.setName("B");
		b.start();

		ThreadC c = new ThreadC(service);
		c.setName("C");
		c.start();

	}

}
