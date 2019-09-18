package com.atmecs.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.atmecs.constants.ValidatingData;
import com.atmecs.constants.YatraFlightBookingLocators;
import com.atmecs.helpers.CommonUtility;

//In this class, validation of flight duration and flight timings is correct or not

public class FlightDuration {

	List<WebElement> flightDetails = new ArrayList<>();
	ValidatingData data = new ValidatingData();
	YatraFlightBookingLocators locators = new YatraFlightBookingLocators();

	// flight timings are validating

	/**
	 * In this method i'm validating the Timing of the flights for departure and
	 * arrival is correct.
	 * 
	 * @param driver
	 */
	public void isFlightTimingCorrect() {
		flightDetails = CommonUtility.getElementsList(
				YatraFlightBookingLocators.getLocators("loc.review.flightTimings"));
		for (int initial = 0; initial < flightDetails.size(); initial++) {
			String element = flightDetails.get(initial).getText();
			if (initial == 0) {
				Assert.assertEquals(element, ValidatingData.getValidatingData("departure.departureTiming"),
						"Departure time is not Correct");
			} else if (initial == 1) {
				Assert.assertEquals(element, ValidatingData.getValidatingData("departure.arrivalTimings"),
						"Arrival time is not correct");
			} else if (initial == 2) {
				Assert.assertEquals(element, ValidatingData.getValidatingData("return.departureTimings"),
						"Return Flight departure time is not correct");
			} else if (initial == 3) {
				Assert.assertEquals(element, ValidatingData.getValidatingData("return.arrivalTimings"),
						"Return Flight arrival time is not correct");
			}
		}
		System.out.println("Flight timings are correct");
	}

	/**
	 * In this method i'm validating the Duration of the flights for departure and
	 * arrival is correct.
	 * 
	 * @param driver
	 */
	public void isFlightDurationCorrect() {
		flightDetails = CommonUtility.getElementsList(
				YatraFlightBookingLocators.getLocators("loc.review.flightDurations"));
		for (int initial = 0; initial < flightDetails.size(); initial++) {
			String element = flightDetails.get(initial).getText();
			if (initial == 0) {
				Assert.assertEquals(element, ValidatingData.getValidatingData("departureDuration"),
						"Departure duration is not Correct");
			} else if (initial == 1) {
				Assert.assertEquals(element, ValidatingData.getValidatingData("arrivalDuration"),
						"Arrival duration is not correct");
			}
		}
		System.out.println("Flight Durations are correct");
	}
}
