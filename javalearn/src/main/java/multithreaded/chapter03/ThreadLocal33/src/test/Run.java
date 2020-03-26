package multithreaded.chapter03.ThreadLocal33.src.test;

import multithreaded.chapter03.InheritableThreadLocal1.src.tools.Tools;
import multithreaded.chapter02.twoNoStop.src.extthread.ThreadA;

public class Run {

	public static void main(String[] args) {
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println("       ��Main�߳���ȡֵ=" + Tools.tl.get());
				Thread.sleep(100);
			}
			Thread.sleep(5000);
			ThreadA a = new ThreadA();
			a.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
