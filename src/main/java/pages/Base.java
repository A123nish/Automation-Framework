package pages;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

/* This class is holding the properties of Browser */
public class Base {
	public static WebDriver driver;

	/*
	 * This method will set the path of driver.exe and instantiate browser.
	 */

	@Parameters({ "browserName" })
	@BeforeSuite
	public void initializeBrowser(String browserName) {
		System.out.println("Browser name is " + browserName);

		if (browserName.equalsIgnoreCase("firefox")) {
			String projectpath = System.getProperty("user.dir"); // it will give location for our project
			System.setProperty("webdriver.gecko.driver", projectpath + "/drivers/geckodriver/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else if (browserName.equalsIgnoreCase("chrome")) {
			String projectpath = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", projectpath + "/drivers/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	// This method will take screenShot on failure of test execution
	@AfterMethod
	public void screenShot(ITestResult result) {
		/*
		 * using ITestResult.FAILURE is equals to result.getStatus then it enter into if
		 * condition
		 */
		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				// To create reference of TakesScreenshot
				TakesScreenshot screenshot = (TakesScreenshot) driver;
				// Call method to capture screenshot
				File src = screenshot.getScreenshotAs(OutputType.FILE);
				String projectpath = System.getProperty("user.dir");
				/*
				 * Copy files to specific location result.getName() will return name of test
				 * case so that screenshot name will be same as test case name
				 */
				FileUtils.copyFile(src, new File(projectpath + "\\ScreenshotOnFailiure\\" + result.getName() + ".png"));
				System.out.println("Successfully captured a screenshot");
			} catch (Exception e) {
				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
		}

	}

	// This method will close the browser
	@AfterSuite
	public void closeBrowser() {
		driver.close();
		System.out.println("Test completed successfully");
	}
}
