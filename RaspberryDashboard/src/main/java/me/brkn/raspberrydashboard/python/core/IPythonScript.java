package me.brkn.raspberrydashboard.python.core;

import org.python.core.PyObject;

public interface IPythonScript {

	public String getScriptFileName();

	public String getFunctionName();

	public PyObject[] getParameters();

	public IPythonResult mapResultToPythonResult(PyObject pythonResult);
}
