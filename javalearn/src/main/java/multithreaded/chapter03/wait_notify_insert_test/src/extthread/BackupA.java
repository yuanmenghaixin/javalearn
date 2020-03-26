package multithreaded.chapter03.wait_notify_insert_test.src.extthread;

import multithreaded.chapter03.wait_notify_insert_test.src.service.DBTools;

public class BackupA extends Thread {

	private DBTools dbtools;

	public BackupA(DBTools dbtools) {
		super();
		this.dbtools = dbtools;
	}

	@Override
	public void run() {
		dbtools.backupA();
	}

}
