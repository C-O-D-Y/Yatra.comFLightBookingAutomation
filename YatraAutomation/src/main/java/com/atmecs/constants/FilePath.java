package com.atmecs.constants;

import java.io.File;

/**
 * In this Class, All the file paths which has been used is saved
 */
public class FilePath {

	public final static String USER_HOME = System.getProperty("user.dir") + File.separator;
	public final static String RESOURCES_HOME = USER_HOME + "src" + File.separator + "test" + File.separator
			+ "resources" + File.separator;
	public final static String LOCATOR_HOME = RESOURCES_HOME + "locators" + File.separator + "yatrahomepage.properties";
	public final static String LIB_HOME = USER_HOME + "lib" + File.separator;

	public final static String CONFIG_FILE = RESOURCES_HOME + "testData" + File.separator + "config.properties";
	public final static String VALIDATION_FILE = RESOURCES_HOME + "testData" + File.separator + "validation.properties";
	public final static String CHROME_PATH = LIB_HOME + "chromedriver.exe";
	public final static String FIREFOX_PATH = LIB_HOME + "geckodriver.exe";
	public final static String IE_PATH = LIB_HOME + "IEDriver.exe";

	public final static String JIRA_CONFIG = USER_HOME + "jiraConfig.properties";
	public final static String ONEWAY_FILE = LOCATOR_HOME + "oneWay.properties";
	public final static String ROUNDTRIP_FILE = LOCATOR_HOME + "roundTrip.properties";
	public final static String TESTDATA_FILE = RESOURCES_HOME + "testData" + File.separator + "testinput.xlsx";
	public static final String EXTENT_REPORT_FILE = USER_HOME + "test-output" + File.separator + "ExtentReport.html";
	public static final String EXTENT_CONFIG = USER_HOME + "extent-config.xml";
	public static final String FAILED_SCREENSHOT_FILE = USER_HOME + "FailedTestScreenShots" + File.separator;
	public final static String LOG4J_FILE = RESOURCES_HOME + "log4j" + File.separator + "log4j.properties";
	public final static int TIMEOUT_INSECONDS = 30;

	public static void main(String[] args) {
		System.out.println(EXTENT_CONFIG);
	}
}
