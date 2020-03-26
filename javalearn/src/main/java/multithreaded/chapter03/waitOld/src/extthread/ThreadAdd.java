package multithreaded.chapter03.waitOld.src.extthread;

import multithreaded.chapter03.waitOld.src.entity.Add;

public class ThreadAdd extends Thread {

	private Add p;

	public ThreadAdd(Add p) {
		super();
		this.p = p;
	}

	@Override
	public void run() {
		p.add();
	}

}
