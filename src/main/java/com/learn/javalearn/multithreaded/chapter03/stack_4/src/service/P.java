package multithreaded.chapter03.stack_4.src.service;

import multithreaded.chapter03.stack_1.src.entity.MyStack;

public class P {

	private MyStack myStack;

	public P(MyStack myStack) {
		super();
		this.myStack = myStack;
	}

	public void pushService() {
		myStack.push();
	}
}
