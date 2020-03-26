package multithreaded.chapter03.p_r_test.src.test;

import multithreaded.chapter03.p_r_allWait.src.entity.P;
import multithreaded.chapter03.p_r_allWait.src.entity.C;
import multithreaded.chapter03.p_r_allWait.src.extthread.ThreadP;
import multithreaded.chapter03.join_sleep_1.src.extthread.ThreadC;

public class Run {

	public static void main(String[] args) {

		String lock = new String("");
		P p = new P(lock);
		C r = new C(lock);

		ThreadP pThread = new ThreadP(p);
		ThreadC rThread = new ThreadC(r);

		pThread.start();
		rThread.start();
	}

}
