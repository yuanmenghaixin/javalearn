package multithreaded.chapter02.syn_Out_asyn.src.test;

import multithreaded.chapter02.syn_Out_asyn.src.mylist.MyList;
import multithreaded.chapter02.syn_Out_asyn.src.extthread.MyThreadA;
import multithreaded.chapter02.syn_Out_asyn.src.extthread.MyThreadB;

public class Test {

	public static void main(String[] args) {
		MyList mylist = new MyList();

		MyThreadA a = new MyThreadA(mylist);
		a.setName("A");
		a.start();

		MyThreadB b = new MyThreadB(mylist);
		b.setName("B");
		b.start();
	}

}
