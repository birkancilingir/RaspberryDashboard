package me.brkn.raspberrydashboard.commandlet.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.brkn.raspberrydashboard.Application;
import me.brkn.raspberrydashboard.ProjectConstants;

public class CommandletExecuter {

	private static final Logger logger = LoggerFactory.getLogger(CommandletExecuter.class);

	private static CommandletExecuter executer = null;

	private CommandletExecuter() {
	}

	public static CommandletExecuter getInstance() {
		if (CommandletExecuter.executer == null)
			CommandletExecuter.executer = new CommandletExecuter();

		return CommandletExecuter.executer;
	}

	private static String getFolderForCurrentOperatingSystem() {
		String operatingSystemName = System.getProperty("os.name");

		logger.info(operatingSystemName);

		return operatingSystemName;

	}

	private String getTempPath() {
		return System.getProperty("java.io.tmpdir");
	}

	// https://stackoverflow.com/a/27437171
	public ICommandletResult executeCommand(ICommandlet commandlet) throws IOException, InterruptedException {
		ClassLoader classLoader = Application.class.getClassLoader();
		String shellScriptPath = classLoader
				.getResource(ProjectConstants.getCommandletsPath() + File.separator
						+ getFolderForCurrentOperatingSystem() + File.separator + commandlet.getCommandFileName())
				.getFile();

		logger.info("shellScriptPath:" + shellScriptPath);

		Process process = new ProcessBuilder("sh", shellScriptPath).redirectErrorStream(true)
				.directory(new File(getTempPath())).start();
		if (process.waitFor(5000, TimeUnit.MILLISECONDS))
			return null;

		String output = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line = null;
		while ((line = reader.readLine()) != null)
			output = output + line;

		return commandlet.mapResult(output);
	}

}
