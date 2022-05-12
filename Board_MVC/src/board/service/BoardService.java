package board.service;

import java.util.List;

import board.vo.BoardVO;

public interface BoardService {
	
	public List<BoardVO> displayPostAll();
	
	public int insertPost(BoardVO bv);
	
	public int updatePost(BoardVO bv);
	
	public int deletePost(int boardNo);
	
	public List<BoardVO> selectPost(BoardVO bv);

	
}
