package multithreaded.chapter03.waitOld.src.extthread;

import multithreaded.chapter03.waitOld.src.entity.Subtract;

public class ThreadSubtract extends Thread {

	private Subtract r;

	public ThreadSubtract(Subtract r) {
		super();
		this.r = r;
	}

	@Override
	public void run() {
		r.subtract();
	}

}
