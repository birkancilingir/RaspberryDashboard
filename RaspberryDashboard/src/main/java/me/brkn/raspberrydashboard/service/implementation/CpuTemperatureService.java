package me.brkn.raspberrydashboard.service.implementation;

import java.io.IOException;

import org.springframework.stereotype.Service;

import me.brkn.raspberrydashboard.commandlet.CpuTemperatureReaderCommandlet;
import me.brkn.raspberrydashboard.commandlet.core.CommandletExecuter;
import me.brkn.raspberrydashboard.commandlet.result.CpuTemperatureReaderResult;
import me.brkn.raspberrydashboard.service.ICpuTemperatureService;
import me.brkn.raspberrydashboard.service.input.CpuTemperatureServiceInput;
import me.brkn.raspberrydashboard.service.output.CpuTemperatureServiceOutput;

@Service
public class CpuTemperatureService implements ICpuTemperatureService {

	public CpuTemperatureServiceOutput getCurrentTemperature(CpuTemperatureServiceInput input)
			throws IOException, InterruptedException {

		CpuTemperatureReaderCommandlet commandlet = new CpuTemperatureReaderCommandlet();
		CpuTemperatureReaderResult result = (CpuTemperatureReaderResult) CommandletExecuter.getInstance()
				.executeCommand(commandlet);

		CpuTemperatureServiceOutput output = new CpuTemperatureServiceOutput();
		output.setCurrentTemperature(result.getTemperature());

		return output;
	}

}
