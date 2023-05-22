package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Base;
import pages.OrangeLoginPage;

public class LoginOrangeTest extends Base {
	@Test()
	public void orangeLogin() {
		//System.out.println("The thread ID for Firefox is "+ Thread.currentThread().getId());

		// goto orangehrm login page
		driver.get("https://opensource-demo.orangehrmlive.com/");

		OrangeLoginPage orangeobj = new OrangeLoginPage(driver);

		orangeobj.enterTextInUsername("Admin");

		orangeobj.enterTextInPassword("admin123");

		orangeobj.clickLoginbutton();

		String actualTitle = driver.getTitle();

		String expectedTitle = "OrangeHRM";

		Assert.assertEquals(actualTitle, expectedTitle);

	}

}
