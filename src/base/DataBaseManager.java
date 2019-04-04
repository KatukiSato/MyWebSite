package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*データベース接続 */
public class DataBaseManager {
	final private static String URL = "jdbc:mysql://localhost/";
	final private static String DB_NAME = "mywebsite?useUnicode=true&characterEncoding=utf8&useSSL=false";
	final private static String USER = "root";
	final private static String PASS = "password";

	/**
	 * DBへ接続するコネクションを返す
	 */
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL + DB_NAME, USER, PASS);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
}