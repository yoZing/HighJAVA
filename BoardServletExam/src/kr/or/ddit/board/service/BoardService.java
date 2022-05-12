package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVO;



public class BoardService implements IBoardService{
	private IBoardDao boardDao;
	private static IBoardService boardService;
	
	public BoardService() {
		boardDao = BoardDao.getInstance();
	}
	
	public static IBoardService getInstance() {
		if (boardService == null) {
			boardService = new BoardService();
		}
		return boardService;
	}
	
	@Override
	public List<BoardVO> printAll() {
		
		return boardDao.printAll();
	}

	@Override
	public int newPost(BoardVO bv) {
		return boardDao.newPost(bv);
	}

	@Override
	public int modify(BoardVO bv) {
		return boardDao.modify(bv);
	}

	@Override
	public int delete(String boardNo) {
		return boardDao.delete(boardNo);
	}

	@Override
	public List<BoardVO> search(BoardVO bv) {
		return boardDao.search(bv);
	}
}
