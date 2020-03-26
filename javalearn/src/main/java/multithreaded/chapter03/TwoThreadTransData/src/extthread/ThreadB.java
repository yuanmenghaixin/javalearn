package multithreaded.chapter03.TwoThreadTransData.src.extthread;

import multithreaded.chapter03.TwoThreadTransData.src.mylist.MyList;

public class ThreadB extends Thread {

	private MyList list;

	public ThreadB(MyList list) {
		super();
		this.list = list;
	}

	@Override
	public void run() {
		try {
			while (true) {
				if (list.size() == 5) {
					System.out.println("==5�ˣ��߳�bҪ�˳��ˣ�");
					throw new InterruptedException();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
