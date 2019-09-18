package com.atmecs.pages;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.atmecs.constants.YatraFlightBookingLocators;
import com.atmecs.helpers.CommonUtility;

//Validating the selection of the flights is correct or not

public class SelectFlights {

	SoftAssert soft = new SoftAssert();
	YatraFlightBookingLocators locaters = new YatraFlightBookingLocators();

	/**
	 * In this method i'm validating the functionality of redirecting the page is
	 * correct.
	 * 
	 * @param driver
	 */
	public void isRedirectionCorrect() {

		String title1 = "Yatra.com | Bengaluru to Mumbai flights] but found [Yatra.com | Bangalore to Mumbai flights";
		String title = CommonUtility.getTitle();
		if (title == title1) {
			Assert.assertEquals(title, title1);
		} else {
			Assert.assertEquals(title, "Yatra.com | Bengaluru to Mumbai flights",
					"Redirection is not on the correct page");
			System.out.println("Redirection is on the correct page");
		}
	}

	/**
	 * In this method i'm validating the functionality of button is displayed or not
	 * 
	 * @param driver
	 * @param xpath
	 */
	public boolean isButtonDisplayed(WebDriver driver, String xpath) {
		BasicConfigurator.configure();
		boolean selected = false;
		selected = CommonUtility.isSelected( YatraFlightBookingLocators.getLocators(xpath));
		soft.assertEquals(selected, true);
		System.out.println("Flight is selected correctly");
		return selected;
	}
}
