package me.brkn.raspberrydashboard.commandlet;

import java.math.BigDecimal;

import me.brkn.raspberrydashboard.commandlet.core.ICommandlet;
import me.brkn.raspberrydashboard.commandlet.core.ICommandletResult;
import me.brkn.raspberrydashboard.commandlet.result.UptimeResult;

public class UptimeCommandlet implements ICommandlet {

	private static final String COMMAND_FILE_NAME = "uptime";

	public String getCommandFileName() {
		return COMMAND_FILE_NAME;
	}

	public String[] getParameters() {
		return null;
	}

	public ICommandletResult mapResult(String commandletResult) {
		if (commandletResult == null || commandletResult.isEmpty())
			return new UptimeResult(BigDecimal.ZERO);

		// 23:14:05 up 37 days, 19:42, 1 user, load average: 0.34, 0.35, 0.27
		int startIndex = commandletResult.indexOf("up") + 3;
		int endIndex = startIndex;
		if (commandletResult.indexOf("days") > 0) {
			endIndex = commandletResult.indexOf("days");
		} else {
			endIndex = commandletResult.indexOf(",", startIndex);
		}

		return new UptimeResult(new BigDecimal(commandletResult.substring(startIndex, endIndex)));
	}

}
