package com.atmecs.testScripts;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.atmecs.constants.YatraFlightBookingLocators;
import com.atmecs.dataProvider.TestDataProvider;
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

	//method use to validate redirection page
	@Test(priority = 1)
	public void homePageRedirection() {
		logger=extent.startTest("Flight Booking");
		log.info("Starting Redirection validation");
		home.isRedirectionCorrect(driver);
		log.info("Redirection is on the correct page");
		log.info("Starting the homepage testing");
	}

	//method validate the input functionality of the inputboxes by giving input in different formats
	@Test(priority = 2, dataProvider = "cityinput", dataProviderClass = TestDataProvider.class)
	public void homePageCityInput(String fromCity, String toCity) throws InterruptedException {
		log.info("Starting homepage flow");
		HomePageFlow.cityInput( fromCity, toCity);
		home.isButtonDisplayed(driver);
		log.info("Round button is working properly");
	}

	//validating the input cities entered is correct or not
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