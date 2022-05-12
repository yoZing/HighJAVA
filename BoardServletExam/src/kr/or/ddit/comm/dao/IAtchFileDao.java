package kr.or.ddit.comm.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.comm.vo.AtchFileVO;

public interface IAtchFileDao {
	
	/**
	 * 첨부파일 입력하기 
	 * @param atchFileVO
	 * @return 첨부파일 정보를 담은 AtchFileVO 객체를 리턴
	 * @throws SQLException
	 */
	public int insertAtchFile(AtchFileVO atchFileVO) throws SQLException;
	
	/**
	 * 첨부파일 세부정보 입력하기
	 * @param atchFileVO
	 * @return 첨부파일의 세부정보를 담은 AtchFileVO 객체를 리턴
	 * @throws SQLException
	 */
	public int insertAtchFileDetail(AtchFileVO atchFileVO) throws SQLException;
	
	/**
	 * 첨부파일 목록을 조회하는 메서드
	 * @param atchFileVO
	 * @return DB에 저장된 첨부파일 목록 객체들을  가진 리스트를 리턴
	 * @throws SQLException
	 */
	public List<AtchFileVO> getAtchFileList(AtchFileVO atchFileVO) throws SQLException;
	
	/**
	 * 첨부파일 세부정보를 조회하는 메서드
	 * @param atchFileVO 가져올 첨부파일 정보(아이디 및 순번)
	 * @return 해당 정보로 조회한 첨부파일 세부정보
	 * @throws SQLException
	 */
	public AtchFileVO getAtchFileDetail(AtchFileVO atchFileVO) throws SQLException;
}
