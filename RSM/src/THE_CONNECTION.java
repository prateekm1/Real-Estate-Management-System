import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class THE_CONNECTION {

	private static String servername="127.0.0.1";
	private static String dbname="rst";
	private static String username="root";
	private static Integer portnumber=3306;
	private static String password="";
	
	public static Connection getTheConnection() {
		Connection connection=null;
		MysqlDataSource datasource=new MysqlDataSource();
		
		datasource.setServerName(servername);
		datasource.setUser(username);
		datasource.setDatabaseName(dbname);
		datasource.setPortNumber(portnumber);
		datasource.setPassword(password);
		
		
		
		try {
			connection=datasource.getConnection();
//			if(connection != null) {
//				System.out.println("connected");
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error");
			e.printStackTrace();
		}
		
		return connection;
	}
}
