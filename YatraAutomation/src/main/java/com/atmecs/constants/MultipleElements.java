package com.atmecs.constants;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.atmecs.helpers.CommonUtility;
import com.atmecs.testBase.TestBase;

public class MultipleElements extends TestBase {
	List<WebElement> webElements = new ArrayList<WebElement>();

	@Test
	public void getElements() throws FileNotFoundException {

		webElements = CommonUtility.getElementsList("//p[@class='custom-autoTxt']");
		try {
			for (int initial = 0; initial < webElements.size(); initial++) {
				String elements = webElements.get(initial).getText();
				// String links = webElements.get(initial).getAttribute("class");
				System.out.println(elements);
			}
		} catch (NullPointerException e) {
			System.out.println("File contains no data");
		}
	}
}
