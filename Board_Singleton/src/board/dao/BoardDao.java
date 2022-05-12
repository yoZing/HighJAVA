package board.dao;

import java.util.List;

import board.vo.BoardVO;

public interface BoardDao {
	
	public List<BoardVO> displayPostAll();
	
	public int insertPost(BoardVO bv);
	
	public int updatePost(BoardVO bv);
	
	public int deletePost(int boardNo);
	
	public List<BoardVO> selectPost(BoardVO bv);
	
	
	
}
