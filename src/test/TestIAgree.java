package test;

import org.testng.annotations.Test;

import page.object.SignInPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestIAgree {
	WebDriver driver;

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

	@Test()
	public void sucessfullyNavigatesToLoginPage() {

		Assert.assertEquals(driver.getTitle(), "Log On or Create Your Account");

	}

	@Test
	public void sucessfullyNavigatesToDemographicsPage() throws InterruptedException {

		SignInPage signinPage = new SignInPage(driver);
		signinPage.navigateToIagreePage().clickToAgree();

		Assert.assertEquals(driver.getTitle(), "Step 1 - People & Contacts");

	}

	@Test
	public void sucessfullyNavigatesToLoginInPageAfterDisagree() {
		// Arrange

		// Act
		SignInPage signinPage = new SignInPage(driver);
		signinPage.navigateToIagreePage().clickToDisagree();

		// Assert

		Assert.assertEquals(driver.getTitle(), "Log On or Create Your Account");

	}

}
