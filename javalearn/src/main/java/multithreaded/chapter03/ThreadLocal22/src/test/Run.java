package multithreaded.chapter03.ThreadLocal22.src.test;

import multithreaded.chapter03.ThreadLocal22.src.ext.ThreadLocalExt;

public class Run {
	public static ThreadLocalExt tl = new ThreadLocalExt();

	public static void main(String[] args) {
		if (tl.get() == null) {
			System.out.println("��δ�Ź�ֵ");
			tl.set("�ҵ�ֵ");
		}
		System.out.println(tl.get());
		System.out.println(tl.get());
	}

}
