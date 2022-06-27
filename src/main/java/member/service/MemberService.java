package member.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import member.bean.MemberDTO;

@Service
public interface MemberService {

	public MemberDTO login(Map<String, String>map);

	public void write(MemberDTO memberDTO);

	public String getMemberById(String id);

	public MemberDTO getMemberBySessionId(String sessionId);

	public void update(Map<String, String> map);

}
