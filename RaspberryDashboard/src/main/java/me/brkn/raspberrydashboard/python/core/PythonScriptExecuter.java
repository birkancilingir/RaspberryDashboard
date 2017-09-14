package me.brkn.raspberrydashboard.python.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.python.core.PyObject;
import org.python.util.PythonInterpreter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.brkn.raspberrydashboard.Application;
import me.brkn.raspberrydashboard.CustomAuthenticationProvider;
import me.brkn.raspberrydashboard.python.core.IPythonResult;
import me.brkn.raspberrydashboard.python.core.IPythonScript;

public class PythonScriptExecuter {

	private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

	private static PythonScriptExecuter executer = null;

	private PythonScriptExecuter() {
	}

	public static PythonScriptExecuter getInstance() {
		if (PythonScriptExecuter.executer == null)
			PythonScriptExecuter.executer = new PythonScriptExecuter();

		return PythonScriptExecuter.executer;
	}

	public IPythonResult executeScript(IPythonScript pythonScript) {

		String script = "";
		BufferedReader reader = null;
		try {
			ClassLoader classLoader = Application.class.getClassLoader();
			File file = new File(classLoader.getResource(pythonScript.getScriptFileName()).getFile());
			reader = new BufferedReader(new FileReader(file));

			String currentLine = null;
			while ((currentLine = reader.readLine()) != null) {
				if (!currentLine.isEmpty()) {
					script = script + currentLine + "\n";
				}
			}
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
		}

		PythonInterpreter interpreter = new PythonInterpreter();
		interpreter.exec(script);

		// Execute a function that takes a string and returns a string
		PyObject function = interpreter.get(pythonScript.getFunctionName());
		PyObject result = function.__call__(pythonScript.getParameters());

		return pythonScript.mapResultToPythonResult(result);

	}
}
