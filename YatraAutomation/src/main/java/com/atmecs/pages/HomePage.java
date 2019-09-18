package com.atmecs.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.atmecs.constants.YatraFlightBookingLocators;
import com.atmecs.helpers.CommonUtility;

//in this class, validation of different functionality is validated of the homepage of yatra.com flight bookings

public class HomePage {
	YatraFlightBookingLocators locaters = new YatraFlightBookingLocators();

	/**
	 * In this method i'm validating the functionality of redirecting the page is
	 * correct.
	 * 
	 * @param driver
	 */
	public void isRedirectionCorrect(WebDriver driver) {

		String title = CommonUtility.getTitle();
		Assert.assertEquals(title, "Flight, Cheap Air Tickets , Hotels, Holiday, Trains Package Booking - Yatra.com",
				"Redirection is not on the correct page");
		System.out.println("Redirection is on the correct page");
	}

	/**
	 * In this method i'm validating the functionality of return date button is
	 * displayed or not after you hit the round trip button
	 * 
	 * @param driver
	 */
	public boolean isButtonDisplayed(WebDriver driver) {
		BasicConfigurator.configure();
		boolean status = false;
		status = CommonUtility.isElementVisible( YatraFlightBookingLocators.getLocators("loc.btn.returnDate"));
		Assert.assertEquals(status, true, "Round button is not working properly");
		System.out.println("Round button is working properly");
		return status;
	}

	/**
	 * In this method im validating the functionality of input boxes If we hit the
	 * round-trip button after the one way button all input boxes elements texts
	 * should remain same
	 * 
	 * @param driver
	 * @return
	 */
	public List<String> changesInElement(WebDriver driver) {
		List<String> stringelement = new ArrayList<String>();
		List<WebElement> element = CommonUtility.getElementsList(
				YatraFlightBookingLocators.getLocators("loc.cityNames.form"));
		for (WebElement webelement : element) {
			stringelement.add(webelement.getText());
		}
		return stringelement;
	}
}
