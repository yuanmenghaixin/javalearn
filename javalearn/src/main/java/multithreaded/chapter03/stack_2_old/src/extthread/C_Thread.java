package multithreaded.chapter03.stack_2_old.src.extthread;

import multithreaded.chapter03.stack_1.src.service.C;

public class C_Thread extends Thread {

	private C r;

	public C_Thread(C r) {
		super();
		this.r = r;
	}

	@Override
	public void run() {
		while (true) {
			r.popService();
		}
	}

}
