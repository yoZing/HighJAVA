package exercise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.JDBCUtil2;

public class Board {
  
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Scanner scan = new Scanner(System.in); 
	
	/**
	 * 메뉴를 출력하는 메서드
	 */
	public void displayMenu(){
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 전체 목록 출력");
		System.out.println("  2. 새글작성");
		System.out.println("  3. 수정");
		System.out.println("  4. 삭제");
		System.out.println("  5. 검색");
		System.out.println("  6. 작업 끝.");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}
	
	/**
	 * 프로그램 시작메서드
	 */
	public void start(){
		int choice;
		do{
			displayMenu(); //메뉴 출력
			choice = Integer.parseInt((scan.nextLine())); // 메뉴번호 입력받기
			switch(choice){
				case 1 :  // 전체 목록 출력
					displayPostAll();
					break;
				case 2 :  // 새글작성
					insertPost();
					break;
				case 3 :  // 수정
					updatePost();
					break;
				case 4 :  // 삭제
					deletePost();
					break;
				case 5 :  // 검색
					selectPost();
					break;
				case 6 :  // 작업 끝
					System.out.println("작업을 마칩니다.");
					break;
				default :
					System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		}while(choice!=5);
	}
	
	private void updatePost() {
		
		System.out.println("작성자를 입력해 주세요.");
		String writer = scan.nextLine();
		System.out.println("제목을 입력해 주세요.");
		String title = scan.nextLine();
		
		System.out.println("새로운 제목을 입력해 주세요.");
		String newTitle = scan.nextLine();
		System.out.println("새로운 작성자를 입력해 주세요.");
		String newWriter = scan.nextLine();
		System.out.println("새로운 날짜를 입력해 주세요.");
		String newDate = scan.nextLine();
		System.out.println("새로운 내용을 입력해 주세요.");
		String newContent = scan.nextLine();
		
		
		
		try {
			conn = JDBCUtil2.getConnection();
			
			String sql = "UPDATE jdbc_board " + 
					"    SET board_title = ? " + 
					"       ,board_writer = ? " + 
					"       ,board_date = ? " + 
					"       ,board_content = ? " + 
					"  where board_title = ? " + 
					"    and board_writer = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newTitle);
			pstmt.setString(2, newWriter);
			pstmt.setString(3, newDate);
			pstmt.setString(4, newContent);
			pstmt.setString(5, title);
			pstmt.setString(6, writer);

			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println("업데이트가 완료되었습니다.");
			} else {
				System.out.println("업데이트에 실패하였습니다.");
			}
		} catch(SQLException ex) {
			System.out.println("업데이트에 실패하였습니다.");
			ex.printStackTrace();
		} finally {
			JDBCUtil2.disConnect(conn, stmt, pstmt, rs);
		}
	}

	private void deletePost() {
		
		System.out.println("작성자를 입력해 주세요.");
		String writer = scan.nextLine();
		System.out.println("제목을 입력해 주세요.");
		String title = scan.nextLine();
		
		try {
			conn = JDBCUtil2.getConnection();
			
			String sql = "delete from JDBC_BOARD where board_writer = ? and board_title = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, title);

			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println("삭제가 완료되었습니다.");
			} else {
				System.out.println("삭제에 실패하였습니다.");
			}
		} catch(SQLException ex) {
			System.out.println("삭제에 실패하였습니다.");
			ex.printStackTrace();
		} finally {
			JDBCUtil2.disConnect(conn, stmt, pstmt, rs);
		}
		
	}

	private void selectPost() {
		
		System.out.println("작성자를 입력해 주세요.");
		String writer = scan.nextLine();
		System.out.println("날짜를 입력해 주세요. (8자리 숫자)");
		String date = scan.nextLine();
	
		
		try {
			
			conn = JDBCUtil2.getConnection();
			
			String sql = "SELECT BOARD_NO, BOARD_TITLE, BOARD_WRITER, BOARD_DATE, BOARD_CONTENT "  
					      +"FROM JDBC_BOARD "  
				    	 +"WHERE BOARD_WRITER = ? " 
					       +"AND BOARD_DATE = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, date);
			
			rs = pstmt.executeQuery();
			
			System.out.println();
			System.out.println("---------------------------------------------");
			System.out.println(" 번 호\t제 목\t작성자\t작성날짜");
			System.out.println("---------------------------------------------");
			while(rs.next()) {
				String number = rs.getString("board_no");
				String title = rs.getString("board_title");
				String wt = rs.getString("board_writer");
				String dt = rs.getString("board_date");
				String content = rs.getString("board_content");
				
				System.out.println(number + "\t" + title + "\t" + wt + "\t" + dt +"\n"
				+ "내용\n" + content);
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil2.disConnect(conn, stmt, pstmt, rs);
		}
	}

	private void insertPost() {
		
		System.out.println("제목을 입력해 주세요.");
		String title = scan.nextLine();
		System.out.println("작성자를 입력해 주세요.");
		String writer = scan.nextLine();
		System.out.println("날짜를 입력해 주세요. (8자리 숫자)");
		String date = scan.nextLine();
		System.out.println("내용을 입력해 주세요.");
		String content = scan.nextLine();
		
		try {
			
			conn = JDBCUtil2.getConnection();
			
			String sql = "INSERT INTO JDBC_BOARD (BOARD_NO, BOARD_TITLE, BOARD_WRITER, BOARD_DATE, BOARD_CONTENT)" 
					   +" VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, writer);
			pstmt.setString(3, date);
			pstmt.setString(4, content);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println("게시물이 작성 되었습니다.");
			} else {
				System.out.println("게시물 작성에 실패하였습니다.");
			}
			
		} catch(SQLException ex) {
			System.out.println("게시물 작성에 실패하였습니다.");
			ex.printStackTrace();
		} finally {
			JDBCUtil2.disConnect(conn, stmt, pstmt, rs);
		}
		
	}

	private void displayPostAll() {
		
		System.out.println();
		System.out.println("---------------------------------------------");
		System.out.println(" 번 호\t제 목\t작성자\t작성날짜");
		System.out.println("---------------------------------------------");
		
		try {
			
			conn = JDBCUtil2.getConnection();
			
			String sql = "select * from jdbc_board";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String number = rs.getString("board_no");
				String title = rs.getString("board_title");
				String writer = rs.getString("board_writer");
				String date = rs.getString("board_date");
				
				System.out.println(number + "\t" + title + "\t" + writer + "\t" + date);
				
			}
			System.out.println("---------------------------------------------");
			System.out.println("출력 작업 끝...");
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		Board board = new Board();
		board.start();
	}
}
