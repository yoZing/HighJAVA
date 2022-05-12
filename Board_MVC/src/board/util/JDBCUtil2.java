package board.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
/*
     db.properties파일의 내용으로 DB정보를 설정하는 방법
     방법1) Properties객체 이용하기
 */
public class JDBCUtil2 {
	
	static Properties prop; // Properties객체변수 선언
	
	static {
		
		prop = new Properties(); // 객체 생성
		
		try {
			
			FileInputStream fis = new FileInputStream("res/db.properties");
			
			prop.load(fis);
			
			fis.close();
			
			Class.forName(prop.getProperty("driver"));
			
		} catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		
	}

	public static Connection getConnection() {
		
		try {
			return DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("user"), prop.getProperty("pass"));
		} catch(SQLException ex) {
			ex.printStackTrace();
			
			return null;
		}
		
	}
	
	public static void disConnect(Connection conn, Statement stmt, PreparedStatement pstmt, ResultSet rs) {
		if(rs != null) try {rs.close();} catch(SQLException ex) {}
		if(stmt != null) try {stmt.close();} catch(SQLException ex) {}
		if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
		if(conn != null) try {conn.close();} catch(SQLException ex) {}
			
		
	}
	
	
	
	
}
