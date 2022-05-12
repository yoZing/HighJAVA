package board.service;

import java.util.List;

import board.dao.BoardDao;
import board.dao.BoardDaoImpl;
import board.vo.BoardVO;

public class BoardServiceImpl implements BoardService{
	
	private static BoardService bService;
	
	private BoardDao bDao;
	
	public BoardServiceImpl() {
		bDao = BoardDaoImpl.getInstance();
	}
	
	public static BoardService getInstance() {
		if(bService == null) {
			bService = new BoardServiceImpl();
		}
		return bService;
		
	}
	
	@Override
	public List<BoardVO> displayPostAll() {
		return bDao.displayPostAll();
	}

	@Override
	public int insertPost(BoardVO bv) {
		return bDao.insertPost(bv);
	}

	@Override
	public int updatePost(BoardVO bv) {
		return bDao.updatePost(bv);
	}

	@Override
	public int deletePost(int boardNo) {
		return bDao.deletePost(boardNo);
	}

	@Override
	public List<BoardVO> selectPost(BoardVO bv) {
		return bDao.selectPost(bv);
	}

}
