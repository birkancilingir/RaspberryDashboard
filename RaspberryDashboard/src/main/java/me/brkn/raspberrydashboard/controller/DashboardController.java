package me.brkn.raspberrydashboard.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController {

	@RequestMapping(value = "/dashboard")
	public ModelAndView requestHandler(WebRequest request) throws IOException, InterruptedException {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("dashboard");

		return mav;
	}

}
