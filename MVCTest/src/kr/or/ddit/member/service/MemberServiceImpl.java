package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {

	
	// 사용할 DAO의 객체변수를 선언한다.
	private IMemberDao memDao;
	
	public MemberServiceImpl() {
		memDao = new MemberDaoImpl();
	}
	
	@Override
	public int insertMember(MemberVO mv) {
		return memDao.insertMember(mv);
	}

	@Override
	public boolean checkMember(String memId) {
		return memDao.checkMember(memId);
	}

	@Override
	public int updateMember(MemberVO mv) {
		return memDao.updateMember(mv);
	}

	@Override
	public int delete(String memId) {
		return memDao.delete(memId);
	}

	@Override
	public List<MemberVO> getAllMemberList() {
		return memDao.getAllMemberList();
	}

	@Override
	public List<MemberVO> searchMember(MemberVO mv) {
		return memDao.searchMember(mv);
	}

}
