package com.atmecs.testScripts;

import org.testng.annotations.Test;

import com.atmecs.constants.YatraFlightBookingLocators;
import com.atmecs.dataProvider.TestDataProvider;
import com.atmecs.helpers.CommonUtility;
import com.atmecs.logReports.LogReport;
import com.atmecs.pages.ErrorMessage;
import com.atmecs.pages.FlightDuration;
import com.atmecs.pages.FlightFare;
import com.atmecs.pages.ReviewBookings;
import com.atmecs.testBase.TestBase;
import com.atmecs.testflow.HomePageFlow;
import com.atmecs.testflow.PassengersDetails;
import com.atmecs.testflow.SelectFlightFlow;

/**
 * Class use to validate the travellers details and the flight details given by
 * the user
 */
public class TravellersDetails extends TestBase {
	ReviewBookings review = new ReviewBookings();
	FlightDuration duration = new FlightDuration();
	FlightFare fare = new FlightFare();
	LogReport log = new LogReport();

	// maintaining the flow of the homepage
	@Test(priority = 6, dataProvider = "cityinput", dataProviderClass = TestDataProvider.class)
	public void doPageFlow(String fromCity, String toCity) {
		try {
			logger = extent.startTest("Traveller details");
			System.out.println(fromCity);

			HomePageFlow.cityInput(fromCity, toCity);
			CommonUtility.action();
//			HomePageFlow.cityInput(driver,"BLR" ,"BOM");

		} catch (InterruptedException e) {
			System.out.println("System Interrupted! please try again");
		}
	}

	// maintaining the flow of the selecting flight page and validating the
	// redirection of the page
	@Test(priority = 7)
	public void reviewBookingDetails() {
		HomePageFlow.dateInput();
		log.info("sorting flights");
		SelectFlightFlow.sortingFlights();
		log.info("selecting flights");
		SelectFlightFlow.selectingFlights();
		log.info("explicit Wait");
		CommonUtility.explicitWait(YatraFlightBookingLocators.getLocators("loc.btn.payment"));
		log.info("Validating the redirection of the web page");
		review.isRedirectionCorrect();
		log.info("Validating the Flight city name");
		review.isFlightCityNameCorrect();
	}

//Validating the flight details
	@Test(priority = 8)
	public void validateFlightDetails() {

		log.info("Validating the Duration of the flights");
		duration.isFlightDurationCorrect();
		log.info("Validating the timing of the flights");
		duration.isFlightTimingCorrect();
		log.info("Validating base fare");
		fare.isBaseFareCorrect();
		log.info("Validating the Taxes");
		fare.isFeeAndSurchargesCorrect();
		log.info("Validating the Total fare");
		fare.isTotalFareCorrect();
		System.out.println("3");
	}

//Validating the error messages functionality
	@Test(priority = 9)
	public void checkFunctionalyInputBoxes() {
		log.info("Validating the input boxes functionality to give error messages");
		ErrorMessage message = new ErrorMessage();
		message.isErrorMessagefunctionalityCorrect();
	}

	// Giving details of the passengers to the input boxes
	@Test(priority = 10, dataProvider = "testinput", dataProviderClass = TestDataProvider.class)
	public void setPassengersData(String firstname, String lastname, String firstname1, String lastname1, String mob_no,
			String email) {
		try {
			PassengersDetails.givePassengersDetails(driver, firstname, lastname, firstname1, lastname1, mob_no, email);

		} catch (InterruptedException e) {
			System.out.println("System Interrupted! please try again");
		}
	}
}
