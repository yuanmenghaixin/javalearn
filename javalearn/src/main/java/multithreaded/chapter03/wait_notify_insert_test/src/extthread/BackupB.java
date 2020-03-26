package multithreaded.chapter03.wait_notify_insert_test.src.extthread;

import multithreaded.chapter03.wait_notify_insert_test.src.service.DBTools;

public class BackupB extends Thread {

	private DBTools dbtools;

	public BackupB(DBTools dbtools) {
		super();
		this.dbtools = dbtools;
	}

	@Override
	public void run() {
		dbtools.backupB();
	}

}
