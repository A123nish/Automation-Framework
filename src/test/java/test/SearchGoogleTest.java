package test;

import org.testng.annotations.Test;

import org.testng.Assert;

import pages.Base;
import pages.GoogleSearchPage;

public class SearchGoogleTest extends Base {

	@Test
	public void googlesearched() {
		//System.out.println("The thread ID for Firefox is "+ Thread.currentThread().getId());

		// goto google.com
		driver.get("https://google.com");

		String ActualTitle = driver.getTitle();

		String ExpectedTitle = "Google";

		Assert.assertEquals(ActualTitle, ExpectedTitle);

		GoogleSearchPage searchpageobj1 = new GoogleSearchPage(driver);

		searchpageobj1.enterTextInSearchBar("testing");

		searchpageobj1.clickSearchButton();
	}

}
