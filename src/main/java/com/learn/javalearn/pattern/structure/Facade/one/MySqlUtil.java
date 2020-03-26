package pattern.structure.Facade.one;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * MySql JDBC
 * 
 * @author Peng.lv
 *
 */
public class MySqlUtil implements JDBCUtil {
	private static Connection conn = null;
	private static Statement st = null;
	private static ResultSet rs = null;
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/test";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	static {
		// 写入驱动所在处，打开驱动
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			System.err.println("MySql数据库连接失败，失败原因：" + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public Statement getStatement() {
		try {
			st = conn.createStatement();
		} catch (Exception e) {
			System.err.println("MySql获取Statement失败，失败原因：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
		return st;
	}

	@Override
	public ResultSet getResultSet(Statement st, String sql) {
		try {
			rs = st.executeQuery(sql);
		} catch (Exception e) {
			System.err.println("MySql获取ResultSet失败，失败原因：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
		return rs;
	}

	@Override
	public void close(Statement st, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			System.err.println("MySql数据库连接关闭失败，失败原因：" + e.getMessage());
			e.printStackTrace();
		}
	}
}
