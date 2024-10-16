package jdbcStudent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	/* DB 접속 객체
	 * DB Driver, url, user, password
	 * com.mysql.cj.jdbc.Driver
	 * jdbc:mysql://localhost:3306/DB명 */
	
	private static DatabaseConnection dbc = new DatabaseConnection();
	private Connection conn = null;
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	private String jdbcUrl = "jdbc:mysql://localhost:3306/javadb";
	
	// 생성자, driver 를 load 하기 위한 메서드
	private DatabaseConnection() {
		try {
			Class.forName(jdbcDriver);
			
			// 연결을 위해서 url, user, password
			conn = DriverManager.getConnection(jdbcUrl, "javaUser", "mysql");
		} catch (ClassNotFoundException e) {
			// driver 를 찾을 수 없을 경우
			System.out.println("driver 를 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			// conn 연결 정보가 잘못되었을 경우
			System.out.println("연결 정보가 정확하지 않습니다.");
			e.printStackTrace();
		}
	}
	
	public static DatabaseConnection getInstance() {
		return dbc;
	}
	
	public Connection getConnection() {
		return conn;
	}
}
