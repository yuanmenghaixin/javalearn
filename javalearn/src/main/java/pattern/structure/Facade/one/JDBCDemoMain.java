package pattern.structure.Facade.one;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Façade门面设计模式为子系统中的一组接口提供一个一致的界面，应用程序本身将不再直接依赖于子系统原件，
 * 而是依赖一个门面，当想要修改某个原件的行为时，
 * 只需要修改实现类即可，应用程序本身不需要做任何修改
 * 
 * @author Peng.lv
 *
 */
public class JDBCDemoMain {
	private static final String SQL = "select * from aaa";
	private static Statement st;
	private static ResultSet rs;

	public static void main(String[] args) {
		// MySql
		JDBCUtil mySqlUtil = new MySqlUtil();
		st = mySqlUtil.getStatement();
		rs = mySqlUtil.getResultSet(st, SQL);
		mySqlUtil.close(st, rs);
		// Oracle
		JDBCUtil oracleUtil = new OracleUtil();
		st = oracleUtil.getStatement();
		rs = oracleUtil.getResultSet(st, SQL);
		oracleUtil.close(st, rs);
	}
}
