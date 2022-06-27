package member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import member.bean.MemberDTO;
import member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping(value = "/member/login")
	@ResponseBody
	public MemberDTO login(@RequestParam Map<String, String>map, HttpServletRequest httpRequest) {
		MemberDTO memberDTO = memberService.login(map);
		HttpSession session = httpRequest.getSession();
		session.setAttribute("sessionId", memberDTO.getId());
		session.setAttribute("sessionName", memberDTO.getName());
		session.setAttribute("sessionEmail", (memberDTO.getEmail1()+"@"+memberDTO.getEmail2()));
		
		return memberDTO;
	}
	
	@PostMapping(value = "/member/checkDuplicate")
	@ResponseBody
	public String checkDuplicate(@RequestParam String id) {
		String duplicateResult = memberService.getMemberById(id);
		System.out.println(duplicateResult); 
		
		return duplicateResult;
	}


//	@RequestMa	pping(value = "/member/writeForm", method = RequestMethod.GET)
//	@ResponseBody
//	public String writeForm() {
//		System.out.println("MemberController 작동, writeForm ");
//		
//		 return "http://localhost:8080/miniProject/member/writeForm.jsp";
//	}
	
	@RequestMapping(value = "/member/writeForm", method = RequestMethod.GET)
	public ModelAndView writeForm() {
		System.out.println("writeForm에 대한 servlet 작동..!");
		ModelAndView mav = new ModelAndView();
		mav.addObject("menu", "/WEB-INF/main/menu.jsp");
		mav.addObject("navigation", "/WEB-INF/main/navigation.jsp");
		mav.addObject("display", "/WEB-INF/member/writeForm.jsp");
		
		mav.setViewName("/index");
		
		return mav;
	}
	
	@PostMapping(value = "/member/write")
	@ResponseBody
	public void write(@ModelAttribute MemberDTO memberDTO) {
		System.out.println("member write controller 작동... 이름  : " + memberDTO.getName());
		memberService.write(memberDTO); 
		
		return ;
	}	
	
	@RequestMapping(value = "/member/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest httpRequest) {
		System.out.println("member.. logout.. servlet 작동..!");
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = httpRequest.getSession();
		session.invalidate();
		
		mav.addObject("menu", "/WEB-INF/main/menu.jsp");
		mav.addObject("navigation", "/WEB-INF/main/navigation.jsp");
		mav.setViewName("/index");
		
		return mav;
	}
	
	@RequestMapping(value = "/member/memberUpdateForm", method = RequestMethod.GET)
	public ModelAndView updateForm() {
		System.out.println("member.. updateFrom.. servlet 작동..!");
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("menu", "/WEB-INF/main/menu.jsp");
		mav.addObject("navigation", "/WEB-INF/main/navigation.jsp");
		mav.addObject("display", "/WEB-INF/member/memberUpdateForm.jsp");

		mav.setViewName("/index");
		
		return mav;
	}
	
	@PostMapping(value = "/member/memberUpdate")
	@ResponseBody
	public void update(@RequestParam Map<String, String> map) {
		System.out.println("member.. update.. servlet 작동..! 넘어온 이름 : " + map.get("name"));
		
		memberService.update(map);
		
		return ;
	}
	
	@PostMapping(value = "/member/getMemberBySessionId")
	@ResponseBody
	public MemberDTO getMemberBySessionId(HttpServletRequest httpRequest) {
		HttpSession session = httpRequest.getSession();
		String sessionId = (String)session.getAttribute("sessionId");
		
		MemberDTO memberDTO = memberService.getMemberBySessionId(sessionId);
		
		return memberDTO;
	}

}
