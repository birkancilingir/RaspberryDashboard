package me.brkn.raspberrydashboard.commandlet.result;

import me.brkn.raspberrydashboard.commandlet.core.ICommandletResult;

public class UptimeResult implements ICommandletResult {

	/**
	 * Uptime since the last system reboot in days / hours / minutes.
	 */
	private String uptime;

	public String getUptime() {
		String uptime = "-";
		if (this.uptime.indexOf("days") > 0) {
			// 23:14:05 up 37 days, 19:42, 1 user, load average: 0.34, 0.35,
			// 0.27
			int startIndex = this.uptime.indexOf("up") + 3;
			int endIndex = this.uptime.indexOf("days");

			uptime = this.uptime.substring(startIndex, endIndex) + " Days";
		} else if (this.uptime.indexOf("mins") > 0) {
			// 23:14:05 up 7 mins, 1 user, load average: 0.34, 0.35,
			// 0.27
			int startIndex = this.uptime.indexOf("up") + 3;
			int endIndex = this.uptime.indexOf("mins");

			uptime = this.uptime.substring(startIndex, endIndex) + " Minutes";
		} else {
			// 23:14:05 up 19:42, 1 user, load average: 0.34, 0.35, 0.27
			int startIndex = this.uptime.indexOf("up") + 3;
			int endIndex = this.uptime.indexOf(",", startIndex);

			uptime = this.uptime.substring(startIndex, endIndex) + " Hours";
		}

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
