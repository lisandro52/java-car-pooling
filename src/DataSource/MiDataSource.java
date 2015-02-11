package DataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MiDataSource {
	private static DataSource dataSource = null;
	static {
		try {
			
			InitialContext ictx = new InitialContext();
			Context ctx = (Context)ictx.lookup("java:/comp/env");
			DataSource ds = (DataSource)ctx.lookup("jdbc/MySQLDS");
			dataSource=ds;
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public static DataSource getDataSource() {
		return dataSource;
	}
}