package multithreaded.chapter07.threadCreateException.src.controller;

import multithreaded.chapter03.isaliveFALSE.src.extthread.MyThread;

public class Main1 {

	public static void main(String[] args) {
		MyThread t = new MyThread();
		t.start();
	}

}
