package multithreaded.chapter01.t13forprint.src.exthread;

public class MyThread extends Thread {
	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 500000; i++) {
			if (this.interrupted()) {
				System.out.println("�Ѿ���ֹͣ״̬��!��Ҫ�˳���!");
				break;
			}
			System.out.println("i=" + (i + 1));
		}
		System.out.println("�ұ����������˴�����for�ּ������У��̲߳�δֹͣ��");
	}
}
