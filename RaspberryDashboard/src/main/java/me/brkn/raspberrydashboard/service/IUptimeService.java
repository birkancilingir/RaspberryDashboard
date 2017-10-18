package me.brkn.raspberrydashboard.service;

import java.io.IOException;

import me.brkn.raspberrydashboard.service.input.UptimeServiceInput;
import me.brkn.raspberrydashboard.service.output.UptimeServiceOutput;

public interface IUptimeService {

	public UptimeServiceOutput getUptime(UptimeServiceInput input) throws IOException, InterruptedException;

}
