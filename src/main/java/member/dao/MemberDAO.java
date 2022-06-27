package member.dao;

import java.util.Map;

import member.bean.MemberDTO;

public interface MemberDAO {

	public MemberDTO login(Map<String, String> map);

	public void write(MemberDTO memberDTO);

	public String getMemberById(String id);

	public MemberDTO getMemberBySessionId(String sessionId);

	public void update(Map<String, String> map);
	

}
