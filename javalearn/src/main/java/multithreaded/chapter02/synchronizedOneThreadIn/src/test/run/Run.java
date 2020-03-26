package  multithreaded.chapter02.synchronizedOneThreadIn.src.test.run;

import multithreaded.chapter02.synchronizedOneThreadIn.src.extthread.ThreadA;
import multithreaded.chapter02.synchronizedOneThreadIn.src.extthread.ThreadB;
import multithreaded.chapter02.synchronizedOneThreadIn.src.service.ObjectService;

public class Run {

	public static void main(String[] args) {
		ObjectService service = new ObjectService();

		ThreadA a = new ThreadA(service);
		a.setName("a");
		a.start();

		ThreadB b = new ThreadB(service);
		b.setName("b");
		b.start();
	}

}
