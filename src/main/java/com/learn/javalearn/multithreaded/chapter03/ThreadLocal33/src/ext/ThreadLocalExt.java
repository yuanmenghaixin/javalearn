package multithreaded.chapter03.ThreadLocal33.src.ext;

import java.util.Date;

public class ThreadLocalExt extends ThreadLocal {
	@Override
	protected Object initialValue() {
		return new Date().getTime();
	}
}
