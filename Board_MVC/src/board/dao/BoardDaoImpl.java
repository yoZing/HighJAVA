package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import board.util.JDBCUtil;
import board.vo.BoardVO;

public class BoardDaoImpl implements BoardDao{
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	@Override
	public List<BoardVO> displayPostAll() {
		
		List<BoardVO> bList = new ArrayList<BoardVO>();
		
		try {
			
			conn = JDBCUtil.getConnection();
			
			String sql = "select * from jdbc_board";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int boardNo = rs.getInt("board_no");
				String boardTitle = rs.getString("board_title");
				String boardWriter = rs.getString("board_writer");
				String boardDate = rs.getString("board_date");
				
				BoardVO bv = new BoardVO();
				bv.setBoardNo(boardNo);
				bv.setBoardTitle(boardTitle);
				bv.setBoardWriter(boardWriter);
				bv.setBoardDate(boardDate);
				
				bList.add(bv);
				
			}
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return bList;
	}

	@Override
	public int insertPost(BoardVO bv) {
		
		int cnt = 0;
		
		try {
			
			conn = JDBCUtil.getConnection();
			
			String sql = "INSERT INTO JDBC_BOARD (BOARD_NO, BOARD_TITLE, BOARD_WRITER, BOARD_DATE, BOARD_CONTENT)" 
					   +" VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bv.getBoardTitle());
			pstmt.setString(2, bv.getBoardWriter());
			pstmt.setString(3, bv.getBoardDate());
			pstmt.setString(4, bv.getBoardContent());
			
			cnt = pstmt.executeUpdate();
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		
		return cnt;
	}

	@Override
	public int updatePost(BoardVO bv) {
		
		int cnt = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			
			String sql = "UPDATE jdbc_board " + 
					"    SET board_title = ? " + 
					"       ,board_writer = ? " + 
					"       ,board_date = ? " + 
					"       ,board_content = ? " + 
					"  where board_no = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bv.getBoardTitle());
			pstmt.setString(2, bv.getBoardWriter());
			pstmt.setString(3, bv.getBoardDate());
			pstmt.setString(4, bv.getBoardContent());
			pstmt.setInt(5,bv.getBoardNo());

			cnt = pstmt.executeUpdate();
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		
		
		return cnt;
	}

	@Override
	public int deletePost(int boardNo) {
		
		int cnt = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			
			String sql = "delete from JDBC_BOARD where board_no = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);

			cnt = pstmt.executeUpdate();
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		
		return cnt;
	}

	@Override
	public List<BoardVO> selectPost(BoardVO bv) {
		
		List<BoardVO> bList = new ArrayList<BoardVO>();
		
		try {
			
			conn = JDBCUtil.getConnection();
			
			String sql = "SELECT BOARD_NO, BOARD_TITLE, BOARD_WRITER, BOARD_DATE, BOARD_CONTENT "  
					      +"FROM JDBC_BOARD "  
				    	 +"WHERE BOARD_NO = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bv.getBoardNo());
			
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				int boardNo = rs.getInt("board_no");
				String boardTitle = rs.getString("board_title");
				String boardWriter = rs.getString("board_writer");
				String boardDate = rs.getString("board_date");
				String boardContent = rs.getString("board_content");
				
				BoardVO bv2 = new BoardVO();
				bv2.setBoardNo(boardNo);
				bv2.setBoardTitle(boardTitle);
				bv2.setBoardWriter(boardWriter);
				bv2.setBoardDate(boardDate);
				bv2.setBoardContent(boardContent);
				
				bList.add(bv2);
				
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		
		return bList;
	}

}
