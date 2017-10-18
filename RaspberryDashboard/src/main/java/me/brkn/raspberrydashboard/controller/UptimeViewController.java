package me.brkn.raspberrydashboard.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import me.brkn.raspberrydashboard.service.IUptimeService;
import me.brkn.raspberrydashboard.service.input.UptimeServiceInput;
import me.brkn.raspberrydashboard.service.output.UptimeServiceOutput;

@RestController
public class UptimeViewController {

	@Autowired
	private IUptimeService uptimeService;

	@RequestMapping("/uptimeview")
	public String requestHandler(WebRequest request) throws IOException, InterruptedException {

		UptimeServiceInput uptimeServiceInput = new UptimeServiceInput();
		UptimeServiceOutput currentUptimeOutput = uptimeService.getUptime(uptimeServiceInput);

		return currentUptimeOutput.getUptime();
	}

}