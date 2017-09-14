package me.brkn.raspberrydashboard.python.script;

import org.python.core.PyBoolean;
import org.python.core.PyObject;

import me.brkn.raspberrydashboard.python.core.IPythonResult;
import me.brkn.raspberrydashboard.python.core.IPythonScript;
import me.brkn.raspberrydashboard.python.result.CpuTimesPythonResult;

public class CpuTimesPythonScript implements IPythonScript {

	private boolean isPerCpu = false;

	public CpuTimesPythonScript(boolean isPerCpu) {
		this.isPerCpu = isPerCpu;
	}

	@Override
	public String getScriptFileName() {
		return "cpu-info.py";
	}

	@Override
	public String getFunctionName() {
		return "cpu_times";
	}

	@Override
	public PyObject[] getParameters() {
		PyObject[] parameters = new PyObject[1];
		parameters[0] = new PyBoolean(this.isPerCpu);

		return parameters;
	}

	
// [scputimes(user=818.91, nice=10.39, system=1245.95, idle=1615311.5, iowait=836.84, irq=0.0, softirq=302.66, steal=0.0, guest=0.0, guest_nice=0.0),
//	scputimes(user=783.36, nice=15.47, system=1150.88, idle=1622040.89, iowait=712.02, irq=0.0, softirq=6.22, steal=0.0, guest=0.0, guest_nice=0.0),
//	scputimes(user=791.93, nice=9.27, system=1068.44, idle=1621842.36, iowait=665.36, irq=0.0, softirq=5.68, steal=0.0, guest=0.0, guest_nice=0.0),
//	scputimes(user=789.39, nice=6.52, system=993.78, idle=1622873.93, iowait=410.55, irq=0.0, softirq=4.11, steal=0.0, guest=0.0, guest_nice=0.0)]

//	scputimes(user=3190.41, nice=41.65, system=4462.87, idle=6493917.21, iowait=2627.54, irq=0.0, softirq=318.69, steal=0.0, guest=0.0, guest_nice=0.0)
	
	@Override
	public IPythonResult mapResultToPythonResult(PyObject pythonResult) {
		CpuTimesPythonResult result = new CpuTimesPythonResult();

		if (this.isPerCpu) {
			String[] realResult = (String[]) pythonResult.__tojava__(String[].class);

		} else {
			String realResult = (String) pythonResult.__tojava__(String.class);

		}

		return result;
	}

}
