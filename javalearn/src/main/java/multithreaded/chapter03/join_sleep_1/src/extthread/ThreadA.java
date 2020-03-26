package multithreaded.chapter03.join_sleep_1.src.extthread;

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
				Thread.sleep(6000);
				// Thread.sleep()���ͷ�����
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
