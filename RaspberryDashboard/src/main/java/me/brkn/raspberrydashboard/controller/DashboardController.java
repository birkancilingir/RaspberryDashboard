package me.brkn.raspberrydashboard.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import me.brkn.raspberrydashboard.service.ICpuTemperatureService;

@Controller
public class DashboardController {

	@Autowired
	private ICpuTemperatureService cpuTemperatureService;

	@RequestMapping(value = "/dashboard")
	public String index(Map<String, Object> model) throws IOException, InterruptedException {

		/*
		 * CpuTemperatureServiceInput cpuTemperatureServiceInput = new
		 * CpuTemperatureServiceInput(); CpuTemperatureServiceOutput
		 * currentCpuTemperatureOutput = cpuTemperatureService
		 * .getCurrentTemperature(cpuTemperatureServiceInput);
		 */

		model.put("time", new Date());
		model.put("message", "Hello World!");
		// model.put("cpuTemperature",
		// currentCpuTemperatureOutput.getCurrentTemperature().setScale(2).toPlainString());

		return "dashboard";

	}

}
