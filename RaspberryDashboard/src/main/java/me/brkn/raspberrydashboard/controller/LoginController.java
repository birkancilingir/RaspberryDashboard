package me.brkn.raspberrydashboard.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping(value = "/login")
	public String index(Map<String, Object> model) {

		return "login";

	}

}
