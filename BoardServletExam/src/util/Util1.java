package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Util1 {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 완료");
			
		} catch(ClassNotFoundException ex) {
			System.out.println("드라이버 로딩 실패...!");
			ex.printStackTrace();
			
		}
	}
	
	public static Connection getConnetion() {
		
		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "KYS95", "java");
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
