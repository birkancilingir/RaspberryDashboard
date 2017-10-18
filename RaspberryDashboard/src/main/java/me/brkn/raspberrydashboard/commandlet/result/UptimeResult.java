package me.brkn.raspberrydashboard.commandlet.result;

import me.brkn.raspberrydashboard.commandlet.core.ICommandletResult;

public class UptimeResult implements ICommandletResult {

	/**
	 * Uptime since the last system reboot in days / hours / minutes.
	 */
	private String uptime;

	public String getUptime() {
		return uptime;
	}

	public void setUptime(String uptime) {
		this.uptime = uptime;
	}

	public UptimeResult() {
	}

	public UptimeResult(String uptime) {
		this.uptime = uptime;
	}

}
