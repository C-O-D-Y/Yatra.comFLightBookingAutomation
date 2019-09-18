package com.atmecs.testScripts;

import org.testng.annotations.Test;

import com.atmecs.constants.YatraFlightBookingLocators;
import com.atmecs.dataProvider.TestDataProvider;
import com.atmecs.helpers.CommonUtility;
import com.atmecs.logReports.LogReport;
import com.atmecs.pages.SelectFlights;
import com.atmecs.testBase.TestBase;
import com.atmecs.testflow.HomePageFlow;
import com.atmecs.testflow.SelectFlightFlow;

public class SelectFlight extends TestBase {
	LogReport log = new LogReport();
	SelectFlights select = new SelectFlights();

	@Test(priority = 4, dataProvider = "cityinput", dataProviderClass = TestDataProvider.class)
	public void doHomePageFlow(String fromCity, String toCity) {
		try {
			logger=extent.startTest("Selecting flights");
			HomePageFlow.cityInput( fromCity, toCity);
		} catch (InterruptedException e) {
			System.out.println("System Interrupted! please try again");
		}
	}

	/**
	 * Method use to validate the sorting and the validating the functionality of
	 * the buttons in the page
	 */
	@Test(priority = 5)
	public void checkSortingButtonFunctionality() {
		
		HomePageFlow.dateInput();
		log.info("Waiting till the sorting button is visible");
		CommonUtility.explicitWait( YatraFlightBookingLocators.getLocators("loc.btn.departure.SortBydeparture"));
		log.info("Validating the redirection of the webpage");
		select.isRedirectionCorrect();
		log.info("Sorting the flights");
		SelectFlightFlow.sortingFlights();
		CommonUtility.scrollDownPage( 0, 600);
		log.info("Validating the return date button is visible or not");
		select.isButtonDisplayed(driver, YatraFlightBookingLocators.getLocators("loc.rbtn.returnFlight"));
		// selecting flights
		SelectFlightFlow.selectingFlights();
	}
}
