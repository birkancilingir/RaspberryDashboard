package me.brkn.raspberrydashboard.commandlet;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import me.brkn.raspberrydashboard.commandlet.core.ICommandlet;
import me.brkn.raspberrydashboard.commandlet.core.ICommandletResult;
import me.brkn.raspberrydashboard.commandlet.result.CpuUtilizationCalculatorResult;

public class CpuUtilizationCalculatorCommandlet implements ICommandlet {

	private static final String COMMAND_FILE_NAME = "cpu-utilization-info";

	public String getCommandFileName() {
		return COMMAND_FILE_NAME;
	}

	public String[] getParameters() {
		return null;
	}

	public ICommandletResult mapResult(String commandletResult)
			throws JsonParseException, JsonMappingException, IOException {
		if (commandletResult == null || commandletResult.isEmpty())
			return new CpuUtilizationCalculatorResult();

		ObjectMapper mapper = new ObjectMapper();
		CpuUtilizationCalculatorResult result = mapper.readValue(commandletResult,
				CpuUtilizationCalculatorResult.class);

		return result;
	}

}
