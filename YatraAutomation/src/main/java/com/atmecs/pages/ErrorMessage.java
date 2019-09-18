package com.atmecs.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.atmecs.constants.ValidatingData;
import com.atmecs.constants.YatraFlightBookingLocators;
import com.atmecs.helpers.CommonUtility;

/**
 * In this class, validation of the error messages given by webpage
 * functionality is done
 */
public class ErrorMessage {
	YatraFlightBookingLocators locators = new YatraFlightBookingLocators();
	List<WebElement> flightDetails = new ArrayList<>();
	ValidatingData data = new ValidatingData();

	/**
	 * In this method, functionality of the error messages for the input boxes is
	 * validated
	 * 
	 * @param WebDriver
	 */
	public void isErrorMessagefunctionalityCorrect() {
		flightDetails = CommonUtility.getElementsList(
				YatraFlightBookingLocators.getLocators("loc.errormsg.txt"));
		for (int initial = 0; initial < flightDetails.size(); initial++) {
			String element = flightDetails.get(initial).getText();
			if (initial == 0) {
				Assert.assertEquals(element, "Email address is required.", "message is not dispalyed");
			} else if (initial == 1) {
				Assert.assertEquals(element, "Mobile number is required.", "message is not dispalyed");
			} else if (initial == 2) {
				Assert.assertEquals(element, "Required.", "message is not dispalyed");
			} else if (initial == 3) {
				Assert.assertEquals(element, "First\r\n" + "							name is required.",
						"message is not dispalyed");
			}
		}
		System.out.println("Flight timings are correct");
	}
}
