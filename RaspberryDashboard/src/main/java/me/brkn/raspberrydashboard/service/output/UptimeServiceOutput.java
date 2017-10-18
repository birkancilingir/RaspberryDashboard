package me.brkn.raspberrydashboard.service.output;

public class UptimeServiceOutput {

	private String uptime;

	/**
	 * @return Uptime since the last system reboot in days / hours / minutes.
	 */
	public String getUptime() {
		return uptime;
	}

	/**
	 * @param uptime
	 *            Uptime since the last system reboot in days / hours / minutes.
	 */
	public void setUptime(String uptime) {
		this.uptime = uptime;
	}

}
