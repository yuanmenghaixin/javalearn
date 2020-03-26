package multithreaded.chapter02.doubleSynBlockOneTwo.src.test.run;

import multithreaded.chapter02.doubleSynBlockOneTwo.src.service.ObjectService;
import multithreaded.chapter02.doubleSynBlockOneTwo.src.extthread.ThreadA;
import multithreaded.chapter02.doubleSynBlockOneTwo.src.extthread.ThreadB;

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
