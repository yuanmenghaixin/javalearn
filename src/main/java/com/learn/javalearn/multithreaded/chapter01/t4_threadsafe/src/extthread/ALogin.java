package multithreaded.chapter01.t4_threadsafe.src.extthread;

import multithreaded.chapter01.t4_threadsafe.src.controller.LoginServlet;

public class ALogin extends Thread {
	@Override
	public void run() {
		LoginServlet.doPost("a", "aa");
	}
}
