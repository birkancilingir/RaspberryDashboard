package me.brkn.raspberrydashboard.commandlet;

public class CpuTemperatureReaderCommandlet implements ICommandlet {

	private static final String COMMAND = "cat /sys/class/thermal/thermal_zone0/temp";
	private static final String EXECUTION_PATH = ".";

	public String getCommand() {
		return CpuTemperatureReaderCommandlet.COMMAND;
	}

	public String getExecutionPath() {
		return CpuTemperatureReaderCommandlet.EXECUTION_PATH;
	}

}
