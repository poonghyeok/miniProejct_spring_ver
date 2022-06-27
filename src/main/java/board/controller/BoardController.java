package board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@GetMapping(value = "/board/boardWriteForm")
	public ModelAndView boardWriteForm() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("menu", "/WEB-INF/main/menu.jsp");
		mav.addObject("navigation", "/WEB-INF/main/navigation.jsp");
		mav.addObject("display", "/WEB-INF/board/boardWriteForm.jsp");
		mav.setViewName("/index");

		return mav;
	}
	
	@PostMapping(value = "/board/boardWrite")
	@ResponseBody
	public void boardWrite(@RequestParam Map<String,String> map, HttpServletRequest servletRequest) {
		
		HttpSession session = servletRequest.getSession();
	
		map.put("id", (String)session.getAttribute("sessionId"));
		map.put("name", (String)session.getAttribute("sessionName"));
		map.put("email", (String)session.getAttribute("sessionEmail"));
			
		boardService.boardWrite(map);
		
		return;

	}
	
	@GetMapping(value = "/board/boardList")
	public ModelAndView boardList() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("menu", "/WEB-INF/main/menu.jsp");
		mav.addObject("navigation", "/WEB-INF/main/navigation.jsp");
		mav.addObject("display", "/WEB-INF/board/boardList.jsp");
		mav.setViewName("/index");
		
		return mav;
	}
	
	@PostMapping(value = "/board/getBoardList")
	@ResponseBody
	public ModelMap getBoardList(@RequestParam(required = false, defaultValue = "1") String pg) {
		ModelMap modelMap = new ModelMap();
		int page = Integer.parseInt(pg);
		int startNum = 1+5*(page-1);
		int endNum = startNum + 4;
		Map<String, Integer> map = new HashMap<String,Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		List<BoardDTO> list = boardService.getBoardList(map);
		
		//bardPaing 객체 생성 및 계산은 boardServiceImpl에서 하도록 하고 여기선 객체만 return 받아서 modelMap에 실어주는 것으로 하자. 
		
		BoardPaging boardPaging = boardService.getBoardPaging(page);
		modelMap.addAttribute("list", list);
		modelMap.addAttribute("pagingHTML", boardPaging.getPagingHTML().toString());
		
		return modelMap;
	}
	

}
