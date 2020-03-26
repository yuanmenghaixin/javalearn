package multithreaded.chapter07.threadCreateException.src.extthread;

public class MyThread extends Thread {
	@Override
	public void run() {
		String username = null;
		System.out.println(username.hashCode());
	}

}
