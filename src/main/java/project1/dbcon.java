package project1;

import java.sql.Connection;
import java.sql.DriverManager;
public class dbcon {
	static String DB_DRIVER="com.mysql.cj.jdbc.Driver";
	static String DB_URL="jdbc:mysql://localhost:3306/UserInfo";
	static String DB_USERNAME="root";
	static String DB_PASSWORD="1234";
	public static Connection getCon() throws Exception {
		Class.forName(DB_DRIVER);
		Connection con=DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
		
		return con;
		
		
		
	}

}
