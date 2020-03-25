package multithreaded.chapter01.t4_threadsafe.src.test;


import multithreaded.chapter01.t4_threadsafe.src.extthread.ALogin;
import multithreaded.chapter01.t4_threadsafe.src.extthread.BLogin;

public class Run {

	public static void main(String[] args) {
		ALogin a = new ALogin();
		a.start();
		BLogin b = new BLogin();
		b.start();
	}

}
