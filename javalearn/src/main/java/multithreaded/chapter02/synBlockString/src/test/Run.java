package multithreaded.chapter02.synBlockString.src.test;

import multithreaded.chapter02.synBlockString.src.service.Service;
import multithreaded.chapter02.synBlockString.src.extthread.ThreadA;
import multithreaded.chapter02.synBlockString.src.extthread.ThreadB;

public class Run {

	public static void main(String[] args) {
		Service service = new Service();

		ThreadA a = new ThreadA(service);
		a.setName("A");
		a.start();

		ThreadB b = new ThreadB(service);
		b.setName("B");
		b.start();

	}

}
