package multithreaded.chapter03.stack_2_new_final.src.service;

import multithreaded.chapter03.stack_1.src.entity.MyStack;

public class C {

	private MyStack myStack;

	public C(MyStack myStack) {
		super();
		this.myStack = myStack;
	}

	public void popService() {
		System.out.println("pop=" + myStack.pop());
	}
}
