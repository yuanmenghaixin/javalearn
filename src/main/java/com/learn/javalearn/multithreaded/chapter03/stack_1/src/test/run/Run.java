package multithreaded.chapter03.stack_1.src.test.run;

import multithreaded.chapter03.stack_1.src.entity.MyStack;
import multithreaded.chapter03.stack_1.src.extthread.C_Thread;
import multithreaded.chapter03.stack_1.src.extthread.P_Thread;
import multithreaded.chapter03.stack_1.src.service.C;
import multithreaded.chapter03.stack_1.src.service.P;

public class Run {
	public static void main(String[] args) {
		MyStack myStack = new MyStack();

		P p = new P(myStack);
		C r = new C(myStack);

		P_Thread pThread = new P_Thread(p);
		C_Thread rThread = new C_Thread(r);
		pThread.start();
		rThread.start();
	}

}
