package multithreaded.chapter02.t99.src.test;

import multithreaded.chapter02.t10.src.printstring.PrintString;

public class Run {

	public static void main(String[] args) {
		PrintString printStringService = new PrintString();
		printStringService.printStringMethod();
		System.out.println("��Ҫֹͣ����stopThread="
				+ Thread.currentThread().getName());
		printStringService.setContinuePrint(false);
	}

}
