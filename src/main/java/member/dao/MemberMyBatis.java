package member.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import member.bean.MemberDTO;


@Transactional
@Repository
public class MemberMyBatis implements MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public MemberDTO login(Map<String,String> map) {
		
		return this.sqlSession.selectOne("memberSQL.login", map);
	}

	@Override
	public void write(MemberDTO memberDTO) {
		System.out.println("MemberMyBatis write() method 작동 넘어온 이름 :" + memberDTO.getName());
		sqlSession.insert("memberSQL.memberWrite", memberDTO);
	}
	
	
	@Override
	public String getMemberById(String id) {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO = this.sqlSession.selectOne("memberSQL.getMemberById", id);
		String result = null;
		if(memberDTO != null) {
			result = "exist";
		}else {
			result = "non_exist";
		}
		
		return result;
	}
	
	@Override
	public MemberDTO getMemberBySessionId(String sessionId) {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO = this.sqlSession.selectOne("memberSQL.getMemberById", sessionId);
		System.out.println("getMemberBySessionid 결과 tel 1 : " + memberDTO.getTel1());
		System.out.println("getMemberBySessionid 결과 tel 2 : " + memberDTO.getTel2());
		System.out.println("getMemberBySessionid 결과 tel 3 : " + memberDTO.getTel3());
		
		return memberDTO;
	}
	
	@Override
	public void update(Map<String, String> map) {
		
		this.sqlSession.update("memberSQL.memberUpdate", map);
	
	}
	
	
}
