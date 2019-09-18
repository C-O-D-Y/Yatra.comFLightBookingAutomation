package com.atmecs.testflow;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.atmecs.constants.YatraFlightBookingLocators;
import com.atmecs.helpers.CommonUtility;

/**
 * Class used to maintain the flow of the passenger details page
 */
public class PassengersDetails {

	/**
	 * Method is used to give input to the passengers details and contact
	 * information
	 */
	public static void givePassengersDetails(WebDriver driver, String firstname, String lastname, String firstname1,
			String lastname1, String mob_no, String email) throws InterruptedException {
		boolean emailInputboxVisibility = false;
		Actions action = new Actions(driver);
		BasicConfigurator.configure();
		CommonUtility.explicitWait( YatraFlightBookingLocators.getLocators("loc.totalFare.txt"));
		// using action class to scroll page down
		action.sendKeys(Keys.SPACE).build().perform();
		// scrolling down the page
		emailInputboxVisibility = CommonUtility.isElementVisible(
				YatraFlightBookingLocators.getLocators("loc.inputbox.email"));

		// condition visibility of the email input box is checked and according to it
		// next flow is maintained
		System.out.println(emailInputboxVisibility);
		if (emailInputboxVisibility == true) {
			System.out.println("if me a gya");
			CommonUtility.clickElement( YatraFlightBookingLocators.getLocators("loc.inputbox.email"));
			CommonUtility.clickAndSendText( YatraFlightBookingLocators.getLocators("loc.inputbox.email"), 5,
					email);
			CommonUtility.clickElement( YatraFlightBookingLocators.getLocators("loc.inputbox.mobNumber"));
			CommonUtility.clickAndSendText(
					YatraFlightBookingLocators.getLocators("loc.inputbox.mobNumber"), 5, mob_no);
			Thread.sleep(3000);
		}

		else {
			System.out.println("Else me a gya");
			CommonUtility.clickElement(
					YatraFlightBookingLocators.getLocators("loc.inputbox.mobNumberWithoutEmail"));
			CommonUtility.clickAndSendText(
					YatraFlightBookingLocators.getLocators("loc.inputbox.mobNumberWithoutEmail"), 5, mob_no);
		}

		CommonUtility.selectDropdown( YatraFlightBookingLocators.getLocators("loc.btn.title"), 5, "Mr.");
		CommonUtility.clickElement( YatraFlightBookingLocators.getLocators("loc.inputbox.firstname"));
		CommonUtility.clickAndSendText( YatraFlightBookingLocators.getLocators("loc.inputbox.firstname"), 5,
				firstname);
		CommonUtility.clickElement( YatraFlightBookingLocators.getLocators("loc.inputbox.lastname"));
		CommonUtility.clickAndSendText( YatraFlightBookingLocators.getLocators("loc.inputbox.lastname"), 5,
				lastname);
		CommonUtility.selectDropdown( YatraFlightBookingLocators.getLocators("loc.btn.title1"), 5, "Master");
		CommonUtility.clickElement( YatraFlightBookingLocators.getLocators("loc.inputbox.firstname1"));
		CommonUtility.clickAndSendText( YatraFlightBookingLocators.getLocators("loc.inputbox.firstname1"), 5,
				firstname1);
		CommonUtility.clickElement( YatraFlightBookingLocators.getLocators("loc.inputbox.lastname1"));
		CommonUtility.clickAndSendText( YatraFlightBookingLocators.getLocators("loc.inputbox.lastname1"), 5,
				lastname1);

		// scrolling down the page upto the element of payment button is not visible
		CommonUtility.scrollIntoview( YatraFlightBookingLocators.getLocators("loc.btn.payment"));
		CommonUtility.isElementVisible( YatraFlightBookingLocators.getLocators("loc.btn.payment"));
		CommonUtility.clickElement( YatraFlightBookingLocators.getLocators("loc.btn.payment"));
	}
}
