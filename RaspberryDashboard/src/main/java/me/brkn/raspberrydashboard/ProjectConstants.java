package me.brkn.raspberrydashboard;

public class ProjectConstants {
	private static final String DELIMITER = "±";
	private static final String SECONDARY_DELIMITER = "|";

	private static final String ROLE_USER = "ROLE_USER";
	private static final String ROLE_ADMIN = "ROLE_ADMIN";

	private static final String COMMANDLETS_PATH = "commandlets";

	private static final String PROJECT_ENCODING = "UTF-8";

	public static String getDelimiter() {
		return DELIMITER;
	}

	public static String getSecondaryDelimiter() {
		return SECONDARY_DELIMITER;
	}

	public static String getRoleUser() {
		return ROLE_USER;
	}

	public static String getRoleAdmin() {
		return ROLE_ADMIN;
	}

	public static String getCommandletsPath() {
		return COMMANDLETS_PATH;
	}

	public static String getProjectEncoding() {
		return PROJECT_ENCODING;
	}

}
