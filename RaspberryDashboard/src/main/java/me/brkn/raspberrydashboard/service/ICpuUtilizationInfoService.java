package me.brkn.raspberrydashboard.service;

import java.io.IOException;

import me.brkn.raspberrydashboard.service.input.CpuUtilizationInfoServiceInput;
import me.brkn.raspberrydashboard.service.output.CpuUtilizationInfoServiceOutput;

public interface ICpuUtilizationInfoService {

	public CpuUtilizationInfoServiceOutput getCurrentUtilization(CpuUtilizationInfoServiceInput input)
			throws IOException, InterruptedException;

}
