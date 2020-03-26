package multithreaded.chapter02.synLockIn_2.src.extthread;

import  multithreaded.chapter02.synLockIn_2.src.myservice.Sub;

public class MyThread extends Thread {
	@Override
	public void run() {
		Sub sub = new Sub();
		sub.operateISubMethod();
	}

}
