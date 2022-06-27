package main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index() {
		System.out.println("index에 대한 servlet 작동..!");
		ModelAndView mav = new ModelAndView();
		mav.addObject("menu", "/WEB-INF/main/menu.jsp");
		mav.addObject("navigation", "/WEB-INF/main/navigation.jsp");
		mav.setViewName("/index");
		
		return mav;
	}
}
