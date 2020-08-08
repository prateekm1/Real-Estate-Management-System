import java.sql.*;
public class ConnectionDB {
   
      static String JdbcURL = "jdbc:mysql://localhost:3310/rst?useSSL=false";
      static String Username = "root";
      static String password = "";
      static Connection con = null;
      public static Connection getTheConnection() {
      try {
         con = DriverManager.getConnection(JdbcURL, Username, password);
         System.out.println("Connected to MySQL database");
      } catch (Exception e) {
         e.printStackTrace();
      }
	return con;
   }
   
}