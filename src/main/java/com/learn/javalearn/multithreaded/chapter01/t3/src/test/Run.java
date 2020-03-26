package multithreaded.chapter01.t3.src.test;

import multithreaded.chapter01.t3.src.mythread.MyThread;

public class Run {
	public static void main(String[] args) {
		MyThread a = new MyThread("A");
		MyThread b = new MyThread("B");
		MyThread c = new MyThread("C");
		a.start();
		b.start();
		c.start();
	}
}
