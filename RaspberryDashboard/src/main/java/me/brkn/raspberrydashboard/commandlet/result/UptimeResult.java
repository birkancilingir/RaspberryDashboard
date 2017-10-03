package me.brkn.raspberrydashboard.commandlet.result;

import java.math.BigDecimal;

import me.brkn.raspberrydashboard.commandlet.core.ICommandletResult;

public class UptimeResult implements ICommandletResult {

	/**
	 * Uptime since the last system reboot in days / hours.
	 */
	private BigDecimal uptime;

	public BigDecimal getUptime() {
		return uptime;
	}

	public void setUptime(BigDecimal uptime) {
		this.uptime = uptime;
	}

	public UptimeResult() {
	}

	public UptimeResult(BigDecimal uptime) {
		this.uptime = uptime;
	}

}
