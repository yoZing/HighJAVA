package service;

import java.util.List;

import vo.BoardVO;

/**
 *  Service객체는 Dao에 설정된 메서드를 원하는 작업에 맞게 호출하여 결과를 받아오고,
 *  받아온 데이터를 Controller에게 보내주는 역할을 한다
 * @author PC-18
 */
public interface IBoardService {
	
	/**
	 * DB에 저장된 모든 정보를 가져와서 List에 담아 반환하는 메서드  
	 * @param bv
	 * @return BoardVO객체를 담은 List갹채
	 */
	public List<BoardVO> printAll();
	
	/**
	 * BoardVO에 저장된 자료를 DB에 insert하는 메서드
	 * @param bv DB에 insert할 자료가 저장된 BoardVO객체
	 * @return DB작업이 성공하면 1이상의 값이 반환되고 실패하면 0이 반환된다.
	 */
	public int newPost(BoardVO bv);
	
	/**
	 * 하나의 Board자료르 ㄹ이용하여 DB를 update하는 메서드
	 * @param bv update할 회원 정보가 담긴 BoardVO객체
	 * @return 작업성공 : 1, 작업실패 : 0
	 */
	public int modify(BoardVO bv);
	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
	/**
	 * boardNO를 매개변수로 받아서 해당 게시글 정보를 삭제하는 메서드
	 * @param boardNo
	 * @return 작업성공 : 1, 작업실패 : 0
	 */
	public int delete(String boardNo);
	
	/**
	 * BoartVO에 담긴 자료를 이용하여 게시글을 검색하는 메서드 
	 * @param bv 검색할 자료가 들어있는 BoardVO객체
	 * @return 검색한 결과를 담은 List객체
	 */
	public List<BoardVO> search(BoardVO bv);
}
