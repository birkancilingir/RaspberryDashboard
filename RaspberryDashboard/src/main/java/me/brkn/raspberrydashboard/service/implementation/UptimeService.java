package me.brkn.raspberrydashboard.service.implementation;

import java.io.IOException;

import org.springframework.stereotype.Service;

import me.brkn.raspberrydashboard.commandlet.UptimeCommandlet;
import me.brkn.raspberrydashboard.commandlet.core.CommandletExecuter;
import me.brkn.raspberrydashboard.commandlet.result.UptimeResult;
import me.brkn.raspberrydashboard.service.IUptimeService;
import me.brkn.raspberrydashboard.service.input.UptimeServiceInput;
import me.brkn.raspberrydashboard.service.output.UptimeServiceOutput;

@Service
public class UptimeService implements IUptimeService {

	public UptimeServiceOutput getUptime(UptimeServiceInput input) throws IOException, InterruptedException {

		UptimeCommandlet commandlet = new UptimeCommandlet();
		UptimeResult result = (UptimeResult) CommandletExecuter.getInstance().executeCommand(commandlet);

		UptimeServiceOutput output = new UptimeServiceOutput();
		output.setUptime(result.getUptime());

		return output;
	}

}
