package pattern.structure.Facade.one;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * JDBC Facade
 * 
 * @author Peng.lv
 *
 */
public interface JDBCUtil {
	Statement getStatement();

	ResultSet getResultSet(Statement st, String sql);

	void close(Statement st, ResultSet rs);
}
