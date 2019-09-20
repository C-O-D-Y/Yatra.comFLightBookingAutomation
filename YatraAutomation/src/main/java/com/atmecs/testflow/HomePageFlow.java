package com.atmecs.testflow;

import org.apache.log4j.BasicConfigurator;

import com.atmecs.constants.YatraFlightBookingLocators;
import com.atmecs.helpers.CommonUtility;

/**
 * class used to maintain the flow of the homepage of the yatra.com
 */
public class HomePageFlow {
	/**
	 * Method used to give input to the city for departure and round trip
	 */
	public static void cityInput(String fromCity, String toCity) throws InterruptedException {
		BasicConfigurator.configure();

		CommonUtility.clickElement( YatraFlightBookingLocators.getLocators("loc.btn.roundTrip"));
		CommonUtility.clickElement( YatraFlightBookingLocators.getLocators("loc.inputbox.departFrom"));
		CommonUtility.isDisplayed( YatraFlightBookingLocators.getLocators("loc.selectArrivalCity.txt"));
		CommonUtility.clickAndSendText( YatraFlightBookingLocators.getLocators("loc.inputbox.departFrom"), 2,
				fromCity);
		
		CommonUtility.action();
		CommonUtility.clickElement( YatraFlightBookingLocators.getLocators("loc.inputbox.goingTo"));
		CommonUtility.isDisplayed( YatraFlightBookingLocators.getLocators("loc.selectDepartCity.txt"));

		CommonUtility.clickAndSendText( YatraFlightBookingLocators.getLocators("loc.inputbox.goingTo"), 2,
				toCity);
	}

	/**
	 * Method is used to give input of the departure date and the return date
	 */
	public static void dateInput() {
		CommonUtility.clickElement( YatraFlightBookingLocators.getLocators("loc.btn.departureDate"));
		CommonUtility.clickElement( YatraFlightBookingLocators.getLocators("loc.btn.departureDateOption"));
		CommonUtility.clickElement( YatraFlightBookingLocators.getLocators("loc.btn.returnDate"));
		CommonUtility.clickElement( YatraFlightBookingLocators.getLocators("loc.btn.returnDateOption"));
		CommonUtility.clickElement( YatraFlightBookingLocators.getLocators("loc.btn.travellerClass"));
		CommonUtility.clickElement( YatraFlightBookingLocators.getLocators("loc.btn.child"));
		CommonUtility.clickElement( YatraFlightBookingLocators.getLocators("loc.btn.businessClass"));
		CommonUtility.clickElement( YatraFlightBookingLocators.getLocators("loc.cbox.noStop"));
		CommonUtility.clickElement( YatraFlightBookingLocators.getLocators("loc.btn.searchFlights"));
	}
}
