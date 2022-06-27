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
//		@Override
//		public UserDTO getUserById(String searchId) {
//			return sqlSession.selectOne("userSQL.getUserOne", searchId);
//		}
	
		
}
