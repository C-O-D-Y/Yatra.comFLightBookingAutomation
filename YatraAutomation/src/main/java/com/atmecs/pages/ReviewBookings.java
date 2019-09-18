package com.atmecs.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.atmecs.constants.ValidatingData;
import com.atmecs.constants.YatraFlightBookingLocators;
import com.atmecs.helpers.CommonUtility;

//In this class, im validating the bookings data are correct or not

public class ReviewBookings {
	List<WebElement> flightDetails = new ArrayList<>();
	ValidatingData data = new ValidatingData();
	YatraFlightBookingLocators locators = new YatraFlightBookingLocators();

	/**
	 * In this method i'm validating the functionality of redirecting the page is
	 * correct.
	 * 
	 * @param driver
	 */
	public void isRedirectionCorrect() {

		String title=CommonUtility.getTitle();
		Assert.assertEquals(title, "Yatra.com | Book your flight in 3 simple steps",
				"Redirection is not on the correct page");
		System.out.println("Redirection is on the correct page");
	}

	/**
	 * In this method i'm validating the city name for departure and arrival is
	 * correct
	 * 
	 * @param driver
	 */

	public void isFlightCityNameCorrect() {
		flightDetails = CommonUtility.getElementsList(
				YatraFlightBookingLocators.getLocators("loc.review.city"));
		for (int initial = 1; initial < flightDetails.size(); initial++) {
			String element = flightDetails.get(initial).getText();
			System.out.println(element);
			if (initial == 1) {
				Assert.assertEquals(element, ValidatingData.getValidatingData("fromCity"),
						"Departure city is not Correct");
			} else if (initial == 2) {
				Assert.assertEquals(element, ValidatingData.getValidatingData("toCity"), "Arrival city is not correct");
			} else if (initial == 3) {
				Assert.assertEquals(element, ValidatingData.getValidatingData("toCity"),
						"Return Flight departure city is not correct");
			} else if (initial == 4) {
				Assert.assertEquals(element, ValidatingData.getValidatingData("fromCity"),
						"Return Flight arrival city is not correct");
			}
		}
		System.out.println("Flight city names are correct");
	}

}
