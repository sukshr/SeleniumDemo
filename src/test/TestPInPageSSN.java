package test;

import org.testng.annotations.Test;

import page.object.SignInPage;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterTest;

public class TestPInPageSSN {
	WebDriver driver;

	@DataProvider(name = "SSNNumberProvider")
	public Object[][] dataProviderMethod() {
		return new Object[][] { { "2548", "PIN is required" } };
	}

	@Test(dataProvider = "SSNNumberProvider")
	public void entersSSNNumber(String SSNnumber, String expectedMessage) throws InterruptedException {
		// Arrange

		// Act
		SignInPage getin = new SignInPage(driver);
		String validationErrorMsgs = getin.navigatesToPINPage().ssnNumber(SSNnumber).continuebtnHasError()
				.getValidationErrorText();
		// Assert

		boolean validation = validationErrorMsgs.contains(expectedMessage);
		Assert.assertTrue(validation);
		System.out.println("the error message is " + validationErrorMsgs);

	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "selenium\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://www.apply.okhca.org/Site/UserAccountLogin.aspx");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
