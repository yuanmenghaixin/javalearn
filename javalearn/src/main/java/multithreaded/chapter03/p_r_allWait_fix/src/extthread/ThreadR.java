package multithreaded.chapter03.p_r_allWait_fix.src.extthread;

import multithreaded.chapter03.p_r_allWait.src.entity.C;

public class ThreadR extends Thread {

	private C r;

	public ThreadR(C r) {
		super();
		this.r = r;
	}

	@Override
	public void run() {
		while (true) {
			r.getValue();
		}
	}

}
