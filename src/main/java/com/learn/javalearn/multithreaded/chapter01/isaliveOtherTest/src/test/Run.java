package multithreaded.chapter01.isaliveOtherTest.src.test;

import multithreaded.chapter01.isaliveOtherTest.src.mythread.CountOperate;

public class Run {

	public static void main(String[] args) {
		CountOperate c = new CountOperate();
		Thread t1 = new Thread(c);
		System.out.println("main begin t1 isAlive=" + t1.isAlive());
		t1.setName("A");
		t1.start();
		System.out.println("main end t1 isAlive=" + t1.isAlive());
	}

}
