package me.brkn.raspberrydashboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value = "/login")
	public ModelAndView requestHandler(WebRequest request) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");

		return mav;
	}

}
