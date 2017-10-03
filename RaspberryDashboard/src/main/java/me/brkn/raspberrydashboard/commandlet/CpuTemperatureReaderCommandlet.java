package me.brkn.raspberrydashboard.commandlet;

import java.math.BigDecimal;
import java.math.RoundingMode;

import me.brkn.raspberrydashboard.commandlet.core.ICommandlet;
import me.brkn.raspberrydashboard.commandlet.core.ICommandletResult;
import me.brkn.raspberrydashboard.commandlet.result.CpuTemperatureReaderResult;

public class CpuTemperatureReaderCommandlet implements ICommandlet {

	private static final String COMMAND_FILE_NAME = "cpu-temp-info";

	public String getCommandFileName() {
		return COMMAND_FILE_NAME;
	}

	public String[] getParameters() {
		return null;
	}

	public ICommandletResult mapResult(String commandletResult) {
		if (commandletResult == null || commandletResult.isEmpty())
			return new CpuTemperatureReaderResult(BigDecimal.ZERO);

		BigDecimal temperature = new BigDecimal(commandletResult);
		temperature = temperature.divide(temperature, 2, RoundingMode.HALF_UP);

		return new CpuTemperatureReaderResult(temperature);
	}

}
