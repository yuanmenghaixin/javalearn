package multithreaded.chapter02.synStaticMethod.src.extthread;

import multithreaded.chapter02.synNotExtends.src.service.Service;

public class ThreadA extends Thread {
	@Override
	public void run() {
		Service.printA();
	}

}
