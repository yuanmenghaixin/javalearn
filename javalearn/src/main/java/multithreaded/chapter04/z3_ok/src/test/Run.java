package multithreaded.chapter04.z3_ok.src.test;

import multithreaded.chapter04.MustUseMoreCondition_Error.src.service.MyService;
import multithreaded.chapter04.z3_ok.src.extthread.MyThreadA;

public class Run {

	public static void main(String[] args) {
		MyService myService = new MyService();
		MyThreadA a = new MyThreadA(myService);
		a.start();
	}
}
