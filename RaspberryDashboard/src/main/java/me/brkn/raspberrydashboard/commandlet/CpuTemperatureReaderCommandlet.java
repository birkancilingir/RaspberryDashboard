package me.brkn.raspberrydashboard.commandlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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

	public ICommandletResult mapResult(String commandletResult)
			throws JsonParseException, JsonMappingException, IOException {
		if (commandletResult == null || commandletResult.isEmpty())
			return new CpuTemperatureReaderResult(BigDecimal.ZERO);

		ObjectMapper mapper = new ObjectMapper();
		CpuTemperatureReaderResult result = mapper.readValue(commandletResult, CpuTemperatureReaderResult.class);
		result.setTemperature(result.getTemperature().divide(new BigDecimal(1000), 2, RoundingMode.HALF_UP));

		return result;
	}

}
