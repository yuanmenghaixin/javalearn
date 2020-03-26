package pattern.structure.Facade.one;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleUtil implements JDBCUtil {
	private static Connection conn = null;
	private static Statement st = null;
	private static ResultSet rs = null;
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "tiger";
	private static final String URL = "jdbc:oracle:thin:@10.9.143.59:1521:oss";
	static {
		// 写入驱动所在处，打开驱动
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			System.err.println("Oracle数据库连接失败，失败原因：" + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public Statement getStatement() {
		try {
			st = conn.createStatement();
		} catch (Exception e) {
			System.err.println("Oracle获取Statement失败，失败原因：" + e.getMessage());
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
			System.err.println("Oracle获取ResultSet失败，失败原因：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
		return rs;
	}

	public void close(Statement st, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			System.err.println("Oracle数据库连接关闭失败，失败原因：" + e.getMessage());
			e.printStackTrace();
		}
	}
}
