package multithreaded.chapter07.formatOK1.src.extthread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import multithreaded.chapter07.formatOK1.src.tools.DateTools;

public class MyThread extends Thread {

	private SimpleDateFormat sdf;
	private String dateString;

	public MyThread(SimpleDateFormat sdf, String dateString) {
		super();
		this.sdf = sdf;
		this.dateString = dateString;
	}

	@Override
	public void run() {
		try {
			Date dateRef = DateTools.parse("yyyy-MM-dd", dateString);
			String newDateString = DateTools.format("yyyy-MM-dd", dateRef)
					.toString();
			if (!newDateString.equals(dateString)) {
				System.out.println("ThreadName=" + this.getName()
						+ "������ �����ַ�����" + dateString + " ת���ɵ�����Ϊ��"
						+ newDateString);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
