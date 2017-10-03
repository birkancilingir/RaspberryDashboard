package me.brkn.raspberrydashboard.commandlet.result;

import java.math.BigDecimal;

import me.brkn.raspberrydashboard.commandlet.core.ICommandletResult;

public class CpuTemperatureReaderResult implements ICommandletResult {

	/**
	 * Temperature of the CPU in Celcius.
	 */
	private BigDecimal temperature;

	public BigDecimal getTemperature() {
		return temperature;
	}

	public void setTemperature(BigDecimal temperature) {
		this.temperature = temperature;
	}

	public CpuTemperatureReaderResult() {
	}

	public CpuTemperatureReaderResult(BigDecimal temperature) {
		this.temperature = temperature;
	}

}
