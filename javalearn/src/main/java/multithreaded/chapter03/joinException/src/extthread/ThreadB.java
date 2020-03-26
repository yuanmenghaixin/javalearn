package multithreaded.chapter03.joinException.src.extthread;

public class ThreadB extends Thread {

	@Override
	public void run() {
		try {
			ThreadA a = new ThreadA();
			a.start();
			a.join();

			System.out.println("�߳�B��run end����ӡ��");
		} catch (InterruptedException e) {
			System.out.println("�߳�B��catch����ӡ��");
			e.printStackTrace();
		}
	}

}
