package me.brkn.raspberrydashboard.service.implementation;

import java.io.IOException;

import org.springframework.stereotype.Service;

import me.brkn.raspberrydashboard.commandlet.CpuUtilizationCalculatorCommandlet;
import me.brkn.raspberrydashboard.commandlet.core.CommandletExecuter;
import me.brkn.raspberrydashboard.commandlet.result.CpuUtilizationCalculatorResult;
import me.brkn.raspberrydashboard.service.ICpuUtilizationInfoService;
import me.brkn.raspberrydashboard.service.input.CpuUtilizationInfoServiceInput;
import me.brkn.raspberrydashboard.service.output.CpuUtilizationInfoServiceOutput;

@Service
public class CpuUtilizationInfoService implements ICpuUtilizationInfoService {

	public CpuUtilizationInfoServiceOutput getCurrentUtilization(CpuUtilizationInfoServiceInput input)
			throws IOException, InterruptedException {
		CpuUtilizationCalculatorCommandlet commandlet = new CpuUtilizationCalculatorCommandlet();
		CpuUtilizationCalculatorResult result = (CpuUtilizationCalculatorResult) CommandletExecuter.getInstance()
				.executeCommand(commandlet);

		CpuUtilizationInfoServiceOutput output = new CpuUtilizationInfoServiceOutput();
		output.setCpuAverage(result.getCpuAverage());
		output.setCore1(result.getCore1());
		output.setCore2(result.getCore2());
		output.setCore3(result.getCore3());
		output.setCore4(result.getCore4());

		return output;
	}

}
