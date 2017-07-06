package me.brkn.raspberrydashboard.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

	@RequestMapping(value = "/dashboard")
	public String index(Map<String, Object> model) throws IOException, InterruptedException {

		// CpuTemperatureReaderCommandlet commandlet = new
		// CpuTemperatureReaderCommandlet(); // ArrayList<String>
		// ArrayList<String> commandResponse =
		// CommandletExecuter.getInstance().executeCommand(commandlet);

		model.put("time", new Date());
		model.put("message", "Hello World!");
		// model.put("commandResponse", commandResponse.get(0));
		return "dashboard";

	}

}
