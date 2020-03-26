package multithreaded.chapter07.groupAddThread.src.test;

import multithreaded.chapter02.twoNoStop.src.extthread.ThreadA;
import multithreaded.chapter02.throwExceptionNoLock.src.extthread.ThreadB;

public class Run {

	public static void main(String[] args) {
		ThreadA aRunnable = new ThreadA();
		ThreadB bRunnable = new ThreadB();

		ThreadGroup group = new ThreadGroup("�ߺ��ҵ��߳���");

		Thread aThread = new Thread(group, aRunnable);
		Thread bThread = new Thread(group, bRunnable);
		aThread.start();
		bThread.start();

		System.out.println("����߳���Ϊ��" + group.activeCount());
		System.out.println("�߳��������Ϊ��" + group.getName());

	}
}
