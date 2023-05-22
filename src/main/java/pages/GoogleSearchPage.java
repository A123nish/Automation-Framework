package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*This class is holding the locator and methods of google search page */

public class GoogleSearchPage {
   public WebDriver driver;

	By textbox_search = By.xpath("//textarea[@name='q']"); // we have two locators and one webdriver reference
	By button_search = By.xpath("(//input[@name='btnK'])[2]");
	
	// this constructor is accepting the driver and initializing its reference
	public GoogleSearchPage(WebDriver driver) { 
		this.driver = driver;
	}

	/* This method is for enter text in search bar */
	public void enterTextInSearchBar(String value) {
		driver.findElement(textbox_search).sendKeys(value);
	}

	/* This method is for click on search button */
	public void clickSearchButton() {
		driver.findElement(button_search).submit();
	}

}
