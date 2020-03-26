package multithreaded.chapter03.join_sleep_2.src.extthread;

public class ThreadA extends Thread {

	private ThreadB b;

	public ThreadA(ThreadB b) {
		super();
		this.b = b;
	}

	@Override
	public void run() {
		try {
			synchronized (b) {
				b.start();
				b.join();// ˵��join�ͷ����ˣ�
				for (int i = 0; i < Integer.MAX_VALUE; i++) {
					String newString = new String();
					Math.random();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
