package me.brkn.raspberrydashboard.python.result;

import java.util.ArrayList;

import me.brkn.raspberrydashboard.python.core.IPythonResult;
import me.brkn.raspberrydashboard.python.result.item.CpuTimesPythonResultItem;

public class CpuTimesPythonResult implements IPythonResult {

	private ArrayList<CpuTimesPythonResultItem> items;

	public ArrayList<CpuTimesPythonResultItem> getItems() {
		return items;
	}

	public void setItems(ArrayList<CpuTimesPythonResultItem> items) {
		this.items = items;
	}

}
