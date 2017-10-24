package me.brkn.raspberrydashboard.commandlet.core;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface ICommandlet {

	public String getCommandFileName();

	public String[] getParameters();

	public ICommandletResult mapResult(String commandletResult)
			throws JsonParseException, JsonMappingException, IOException;

}
