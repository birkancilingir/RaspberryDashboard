package me.brkn.raspberrydashboard.commandlet.core;

public interface ICommandlet {

	public String getCommandFileName();

	public String[] getParameters();

	public ICommandletResult mapResult(String commandletResult);

}
