package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/* This class contains locators and methods of orangehrm login page*/
public class OrangeLoginPage {
	public WebDriver driver;

	By textbox_user = By.xpath("//input[@name='username']"); // we have three locators and one webdriver reference
	By textbox_password = By.xpath("//input[@name='password']");
	By buttonlogin = By.xpath("//button[@type='submit']");

	
	// this constructor is accepting the driver and initializing its reference.
	public OrangeLoginPage(WebDriver driver) { 
		this.driver = driver;
	}

	/* This method is for enter text in Username field */
	public void enterTextInUsername(String value) {
		driver.findElement(textbox_user).sendKeys(value);
	}

	/* This method is for enter text in Password field */
	public void enterTextInPassword(String value) {
		driver.findElement(textbox_password).sendKeys(value);
	}
	
	/* This method is for click on login button */
	public void clickLoginbutton() {
		driver.findElement(buttonlogin).click();
	}
	
}