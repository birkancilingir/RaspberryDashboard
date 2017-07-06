package me.brkn.raspberrydashboard.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.brkn.raspberrydashboard.commandlet.CommandletExecuter;
import me.brkn.raspberrydashboard.commandlet.CpuTemperatureReaderCommandlet;

@RestController
public class CpuTemperatureViewController {

	@RequestMapping("/cputemperatureview")
	public String index() throws IOException, InterruptedException {

		CpuTemperatureReaderCommandlet commandlet = new CpuTemperatureReaderCommandlet();
		ArrayList<String> commandResponse = CommandletExecuter.getInstance().executeCommand(commandlet);

		return commandResponse.get(0);
	}

}
