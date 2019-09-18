package com.atmecs.testflow;

import com.atmecs.constants.YatraFlightBookingLocators;
import com.atmecs.helpers.CommonUtility;

/**
 * Class used maintain the flow of the selecting flight page
 */
public class SelectFlightFlow {

	// method used to sort the flights according to the scenarios
	public static void sortingFlights() {
		boolean visibility = CommonUtility
				.isElementVisible(YatraFlightBookingLocators.getLocators("loc.btn.departure.SortBydeparture"));
		System.out.println(visibility);
		if (visibility == true) {
			CommonUtility.clickElement(YatraFlightBookingLocators.getLocators("loc.btn.departure.SortBydeparture"));
		}
	}

	// Method used to select the flight from the options given
	public static void selectingFlights() {
		CommonUtility.clickElement(YatraFlightBookingLocators.getLocators("loc.btn.return.SortByprice"));
		CommonUtility.clickElement(YatraFlightBookingLocators.getLocators("loc.btn.bookNow"));
	}
}
