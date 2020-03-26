package multithreaded.chapter02.synNotExtends.src.controller;

import multithreaded.chapter02.synNotExtends.src.service.Sub;
import multithreaded.chapter02.synNotExtends.src.extthread.MyThreadA;
import multithreaded.chapter02.synNotExtends.src.extthread.MyThreadB;

public class Test {

	public static void main(String[] args) {
		Sub subRef = new Sub();

		MyThreadA a = new MyThreadA(subRef);
		a.setName("A");
		a.start();

		MyThreadB b = new MyThreadB(subRef);
		b.setName("B");
		b.start();
	}

}
