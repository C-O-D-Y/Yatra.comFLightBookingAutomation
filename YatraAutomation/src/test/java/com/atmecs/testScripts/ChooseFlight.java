package com.atmecs.testScripts;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.atmecs.constants.YatraFlightBookingLocators;
import com.atmecs.dataProvider.TestDataProvider;
import com.atmecs.helpers.CommonUtility;
import com.atmecs.logReports.LogReport;
import com.atmecs.pages.HomePage;
import com.atmecs.testBase.TestBase;
import com.atmecs.testflow.HomePageFlow;

/*
*Class validates the functionality of homepage input boxes and buttons functionality
*/
public class ChooseFlight extends TestBase {
	LogReport log = new LogReport();
	YatraFlightBookingLocators locators = new YatraFlightBookingLocators();
	HomePage home = new HomePage();

	// method use to validate redirection page
	@Test(priority = 1)
	public void homePageRedirection() {
		logger = extent.startTest("Flight Booking");
		log.info("Starting Redirection validation");
		home.isRedirectionCorrect();
		log.info("Redirection is on the correct page");
		log.info("Starting the homepage testing");
	}

	// method use to validate city input is correct or not
	@Test(priority = 1, dataProvider = "wrongcityinput", dataProviderClass = TestDataProvider.class)
	public void correctCityValidation(String fromCity, String toCity) throws InterruptedException {
		logger = extent.startTest("City Validaton");
		log.info("Starting wrong City Input validation");
		HomePageFlow.cityInput(fromCity, toCity);
		home.isMessageDisplayed();
		CommonUtility.clickElement(YatraFlightBookingLocators.getLocators("loc.inputbox.goingTo"));
		CommonUtility.isDisplayed(YatraFlightBookingLocators.getLocators("loc.selectDepartCity.txt"));

		CommonUtility.clickAndSendText(YatraFlightBookingLocators.getLocators("loc.inputbox.goingTo"), 2, "BLR");
		CommonUtility.action();
	}

	// method validate the input functionality of the inputboxes by giving input in
	// different formats
	@Test(priority = 2, dataProvider = "cityinput", dataProviderClass = TestDataProvider.class)
	public void homePageCityInput(String fromCity, String toCity) throws InterruptedException {

		log.info("Starting homepage flow");
		HomePageFlow.cityInput(fromCity, toCity);
		CommonUtility.action();
		home.isButtonDisplayed();
		log.info("Round button is working properly");
	}

	// validating the input cities entered is correct or not
	@Test(priority = 3)
	public void isHomeDataCorrect() {
		log.info("Validating the homepage data");
		List<String> data = home.changesInElement(driver);
		Assert.assertEquals(data.get(0), "BLR");
		Assert.assertEquals(data.get(1), "BOM");
		log.info("All the details of homepage are correct");
		HomePageFlow.dateInput();
	}
}