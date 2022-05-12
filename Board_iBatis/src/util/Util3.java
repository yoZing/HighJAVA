package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Util3 {
	
	static Properties prop;  // Properties 객체변수 선언
	
	static {
		
		prop = new Properties();  // 객체 생성
		
		try {
			
			FileInputStream fis = new FileInputStream("./res/db.properties");
			
			prop.load(fis);
			
			Class.forName(prop.getProperty("driver"));
			System.out.println("드라이버 로딩 완료");
			
		} catch(ClassNotFoundException ex) {
			System.out.println("드라이버 로딩 실패...!");
			ex.printStackTrace();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnetion() {
		
		try {
			return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
		} catch(SQLException ex) {
			ex.printStackTrace();
			
			return null;
		}
	}
	
	public static void disConnect(Connection conn, Statement stmt, PreparedStatement pstmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		
	}
}
