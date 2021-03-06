package member.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public MemberDTO login(Map<String, String>map) {
		
		return memberDAO.login(map); 
	}

	@Override
	public void write(MemberDTO memberDTO) {
		System.out.println("memberServiceImpl write() 호출 , memberDTO 이름 : " + memberDTO.getName());
		memberDAO.write(memberDTO);
	}
	
	@Override
	public String getMemberById(String id) {
		return memberDAO.getMemberById(id);
	}
	
	@Override
	public MemberDTO getMemberBySessionId(String sessionId) {
		
		return memberDAO.getMemberBySessionId(sessionId);
	}
	
	@Override
	public void update(Map<String,String> map) {
		
		memberDAO.update(map);
	}
}
