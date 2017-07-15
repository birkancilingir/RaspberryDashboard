package me.brkn.raspberrydashboard.service;

import java.io.IOException;

import me.brkn.raspberrydashboard.service.input.CpuTemperatureServiceInput;
import me.brkn.raspberrydashboard.service.output.CpuTemperatureServiceOutput;

public interface ICpuTemperatureService {

	public CpuTemperatureServiceOutput getCurrentTemperature(CpuTemperatureServiceInput input)
			throws IOException, InterruptedException;

}
