package me.brkn.raspberrydashboard.controller;

import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import me.brkn.raspberrydashboard.service.ICpuTemperatureService;

@Controller
public class DashboardController {

	@Autowired
	private ICpuTemperatureService cpuTemperatureService;

	@RequestMapping(value = "/dashboard")
	public ModelAndView requestHandler(WebRequest request) throws IOException, InterruptedException {

		// CpuTemperatureServiceInput cpuTemperatureServiceInput = new
		// CpuTemperatureServiceInput();
		// CpuTemperatureServiceOutput currentCpuTemperatureOutput =
		// cpuTemperatureService
		// .getCurrentTemperature(cpuTemperatureServiceInput);

		ModelAndView mav = new ModelAndView();
		mav.addObject("time", new Date());
		mav.addObject("message", "Hello World!");
		// mav.addObject("cpuTemperature",
		// currentCpuTemperatureOutput.getCurrentTemperature().setScale(2).toPlainString());
		mav.setViewName("dashboard");

		return mav;
	}

}
