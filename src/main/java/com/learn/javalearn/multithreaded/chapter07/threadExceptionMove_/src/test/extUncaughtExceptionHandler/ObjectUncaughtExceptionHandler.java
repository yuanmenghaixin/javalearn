package multithreaded.chapter07.threadExceptionMove_.src.test.extUncaughtExceptionHandler;

import java.lang.Thread.UncaughtExceptionHandler;

public class ObjectUncaughtExceptionHandler implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("对象的异常处理");
		e.printStackTrace();
	}

}
