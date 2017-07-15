package me.brkn.raspberrydashboard.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.brkn.raspberrydashboard.service.ICpuTemperatureService;
import me.brkn.raspberrydashboard.service.input.CpuTemperatureServiceInput;
import me.brkn.raspberrydashboard.service.output.CpuTemperatureServiceOutput;

@RestController
public class CpuTemperatureViewController {

	@Autowired
	private ICpuTemperatureService cpuTemperatureService;

	@RequestMapping("/cputemperatureview")
	public String index() throws IOException, InterruptedException {

		CpuTemperatureServiceInput cpuTemperatureServiceInput = new CpuTemperatureServiceInput();
		CpuTemperatureServiceOutput currentCpuTemperatureOutput = cpuTemperatureService
				.getCurrentTemperature(cpuTemperatureServiceInput);

		return currentCpuTemperatureOutput.getCurrentTemperature().setScale(2).toPlainString();
	}

}
