package me.brkn.raspberrydashboard.controller;

import java.io.IOException;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import me.brkn.raspberrydashboard.service.ICpuUtilizationInfoService;
import me.brkn.raspberrydashboard.service.input.CpuUtilizationInfoServiceInput;
import me.brkn.raspberrydashboard.service.output.CpuUtilizationInfoServiceOutput;

@RestController
public class CpuUtilizationInfoController {

	@Autowired
	private ICpuUtilizationInfoService cpuUtilizationInfoService;

	@RequestMapping("/cpuutilizationinfoview")
	public String requestHandler(WebRequest request) throws IOException, InterruptedException {

		CpuUtilizationInfoServiceInput cpuUtilizationInfoServiceInput = new CpuUtilizationInfoServiceInput();
		CpuUtilizationInfoServiceOutput currentCpuUtilizationInfoOutput = cpuUtilizationInfoService
				.getCurrentUtilization(cpuUtilizationInfoServiceInput);

		return currentCpuUtilizationInfoOutput.getCpuAverage().setScale(2, RoundingMode.HALF_EVEN).toPlainString();
	}
}