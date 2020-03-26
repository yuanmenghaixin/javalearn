package multithreaded.chapter02.setNewPropertiesLockOne.src.test.run;

import multithreaded.chapter02.setNewPropertiesLockOne.src.service.Service;
import multithreaded.chapter02.setNewPropertiesLockOne.src.entity.Userinfo;
import multithreaded.chapter02.setNewPropertiesLockOne.src.extthread.ThreadA;
import multithreaded.chapter02.setNewPropertiesLockOne.src.extthread.ThreadB;

public class Run {

	public static void main(String[] args) {

		try {
			Service service = new Service();
			Userinfo userinfo = new Userinfo();

			ThreadA a = new ThreadA(service, userinfo);
			a.setName("a");
			a.start();
			Thread.sleep(50);
			ThreadB b = new ThreadB(service, userinfo);
			b.setName("b");
			b.start();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
