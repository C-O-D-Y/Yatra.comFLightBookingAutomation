package com.atmecs.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.atmecs.constants.ValidatingData;
import com.atmecs.constants.YatraFlightBookingLocators;
import com.atmecs.helpers.CommonUtility;

//validation of the flight fare is being done in this class

public class FlightFare {

	List<WebElement> flightDetails = new ArrayList<>();
	ValidatingData data = new ValidatingData();
	SoftAssert softAssert = new SoftAssert();
	YatraFlightBookingLocators locators = new YatraFlightBookingLocators();

	/**
	 * In this method i'm validating the basefare for departure and arrival is
	 * correct
	 * 
	 * @param driver
	 */
	public void isBaseFareCorrect() {
		WebElement key = CommonUtility.getElement( YatraFlightBookingLocators.getLocators("loc.btn.basefare"));
		String element = key.getText();
		softAssert.assertEquals(element, ValidatingData.getValidatingData("baseFare"), "BaseFare is not Correct");
		System.out.println("Total Basefare is correct");
	}

	/**
	 * In this method i'm validating the taxes for departure and arrival is correct
	 * 
	 * @param driver
	 */
	public void isFeeAndSurchargesCorrect() {
		WebElement key = CommonUtility.getElement(
				YatraFlightBookingLocators.getLocators("loc.btn.feeAndSurcharges"));
		String element = key.getText();
		softAssert.assertEquals(element, ValidatingData.getValidatingData("feeAndSurcharges"),
				"taxes Fare is not Correct");
		System.out.println("Total Fee and surcharges fare is correct");
	}

	/**
	 * In this method i'm validating the totalfare for departure and arrival is
	 * correct
	 * 
	 * @param driver
	 */
	public void isTotalFareCorrect() {
		WebElement key = CommonUtility.getElement( YatraFlightBookingLocators.getLocators("loc.btn.totalFare"));
		String element = key.getText();
		softAssert.assertEquals(element, ValidatingData.getValidatingData("totalFare"), "total Fare is not Correct");
		System.out.println("Total fare is correct");
		softAssert.assertAll();
	}
}
