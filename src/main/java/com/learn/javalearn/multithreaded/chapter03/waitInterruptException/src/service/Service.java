package multithreaded.chapter03.waitInterruptException.src.service;

public class Service {

	public void testMethod(Object lock) {
		try {
			synchronized (lock) {
				System.out.println("begin wait()");
				lock.wait();
				System.out.println("  end wait()");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("�����쳣�ˣ���Ϊ��wait״̬���̱߳�interrupt�ˣ�");
		}
	}

}
