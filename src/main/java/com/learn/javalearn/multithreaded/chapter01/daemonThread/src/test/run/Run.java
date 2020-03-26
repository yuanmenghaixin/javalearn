package multithreaded.chapter01.daemonThread.src.test.run;

import multithreaded.chapter01.useStopMethodThreadTest.src.testpackage.MyThread;

public class Run {
	public static void main(String[] args) {
		try {
			MyThread thread = new MyThread();
			thread.setDaemon(true);
			thread.start();
			Thread.sleep(5000);
			System.out.println("���뿪thread����Ҳ���ٴ�ӡ�ˣ�Ҳ����ֹͣ�ˣ�");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
