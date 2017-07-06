package me.brkn.raspberrydashboard.commandlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class CommandletExecuter {

	private static CommandletExecuter executer = null;

	private CommandletExecuter() {
	}

	public static CommandletExecuter getInstance() {
		if (CommandletExecuter.executer == null)
			CommandletExecuter.executer = new CommandletExecuter();

		return CommandletExecuter.executer;
	}

	// https://stackoverflow.com/a/27437171
	public ArrayList<String> executeCommand(ICommandlet commandlet) throws IOException, InterruptedException {
		Process process = new ProcessBuilder(new String[] { "bash", "-c", commandlet.getCommand() })
				.redirectErrorStream(true).directory(new File(commandlet.getExecutionPath())).start();

		ArrayList<String> output = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line = null;
		while ((line = reader.readLine()) != null)
			output.add(line);

		if (process.waitFor(5000, TimeUnit.MILLISECONDS))
			return null;

		return output;
	}

}
