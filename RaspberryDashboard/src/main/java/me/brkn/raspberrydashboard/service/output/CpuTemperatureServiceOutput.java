package me.brkn.raspberrydashboard.service.output;

import java.math.BigDecimal;

public class CpuTemperatureServiceOutput {

	private BigDecimal currentTemperature;

	/**
	 * @return Current temperature of the CPU
	 */
	public BigDecimal getCurrentTemperature() {
		return currentTemperature;
	}

	/**
	 * @param currentTemperature
	 *            Current temperature of the CPU
	 */
	public void setCurrentTemperature(BigDecimal currentTemperature) {
		this.currentTemperature = currentTemperature;
	}

}
