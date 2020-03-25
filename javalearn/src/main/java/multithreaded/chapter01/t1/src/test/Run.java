package multithreaded.chapter01.t1.src.test;

import  multithreaded.chapter01.t1.src.com.mythread.www.MyThread;

public class Run {

	public static void main(String[] args) {
		MyThread mythread = new MyThread();
		mythread.start();
		System.out.println("���н�����");
	}

}
