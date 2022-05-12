package dao;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;

import util.Util4;
import vo.BoardVO;

public class BoardDao implements IBoardDao{
	
	private static IBoardDao boardDao;
	
	private BoardDao() {
	}
	
	public static IBoardDao getInstance() {
		if (boardDao == null) {
			boardDao = new BoardDao();
		}
		return boardDao;
	}

	@Override
	public List<BoardVO> printAll() {
		List<BoardVO> boardList = null;
		try {
			Util4.getConnection();
			boardList = Util4.smc.queryForList("board.printAll");
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardList;
	}
		

	@Override
	public int newPost(BoardVO bv) {
		
		int cnt = 0;
		
		try {

			Util4.getConnection();
			
			cnt = (int) Util4.smc.update("board.insertboard", bv);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	
	@Override
	public int modify(BoardVO bv) {
		
		int cnt = 0;
		
		try {
			
			Util4.getConnection();
			
			cnt = Util4.smc.update("board.updateboard", bv);
			
		} catch(SQLException e) {
			e.printStackTrace();
		} 
		return cnt;
	}

	@Override
	public int delete(String boardNo) {
		
		int cnt = 0;
		
		try {
			
			Util4.getConnection();
			
			cnt = Util4.smc.delete("board.deleteboard", boardNo);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<BoardVO> search(BoardVO bv) {
		List<BoardVO> boardList = null;
		
		try {
			Util4.getConnection();
			boardList = Util4.smc.queryForList("board.searchboard");
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardList;
	}

}
