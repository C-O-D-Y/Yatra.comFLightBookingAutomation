package com.atmecs.dataProvider;

import org.testng.annotations.DataProvider;

import com.atmecs.constants.FilePath;
import com.atmecs.utils.ProvideData;

/**
 * In this class, data is given from the dataprovider
 */
public class TestDataProvider {
	/**
	 * In this method, getting the data of the city into object array and returning
	 * to the calling method
	 */

	@DataProvider(name = "cityinput")
	public Object[][] getCityData() {
		ProvideData provideData = new ProvideData(FilePath.TESTDATA_FILE, 0);
		Object[][] getData = provideData.provideExcelData();
		return getData;
	}

	/**
	 * In this method, getting the data of the passengers details into object array
	 * and returning to the calling method
	 */

	@DataProvider(name = "testinput")
	public Object[][] getData() {
		ProvideData provideData = new ProvideData(FilePath.TESTDATA_FILE, 1);
		Object[][] getData = provideData.provideExcelData();
		return getData;
	}

	public static void main(String[] args) {

		Object[][] data = new TestDataProvider().getCityData();
		for (Object[] objects : data) {
			String userName = (String) objects[0];
			String password = (String) objects[1];
			System.out.println(" " + userName + "   " + password);
		}
	}
}