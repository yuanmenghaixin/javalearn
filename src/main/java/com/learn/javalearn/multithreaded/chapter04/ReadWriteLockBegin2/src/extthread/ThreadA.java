package multithreaded.chapter04.ReadWriteLockBegin2.src.extthread;

import multithreaded.chapter04.ReadWriteLockBegin1.src.service.Service;

public class ThreadA extends Thread {

	private Service service;

	public ThreadA(Service service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.write();
	}

}
