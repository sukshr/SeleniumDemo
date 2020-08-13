package test;

import org.testng.annotations.Test;

import page.object.SignInPage;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterTest;

public class TestLastName {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "selenium\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://www.apply.okhca.org/Site/UserAccountLogin.aspx");
		driver.manage().window().maximize();
	}

	@DataProvider(name = "validlastNameProvider")
	public Object[][] dataProviderMethod() {
		return new Object[][] { { "Singylingyface", "First Name is required" },
				{ "HaPPgyHl.Sopa", "First Name is required" }, { "John.Doe", "First Name is required" },
				{ "JohnDoe25", "Last Name must only contain letters" } };
	}

	@Test(dataProvider = "validNameProvider")
	public void passesValidName(String Lastname, String expectedError) throws InterruptedException {
		SignInPage signinPage = new SignInPage(driver);
		String validationMsg = signinPage.navigateToIagreePage().clickToAgree().setFName(Lastname).nexBtnHasError()
				.getValidationText();

		// Assert
		boolean validation = validationMsg.contains(expectedError);
		Assert.assertTrue(validation);

	}

	@DataProvider(name = "invalidlastNameProvider")
	public Object[][] invalidDataProviderMethod() {
		return new Object[][] { { "$$$$", "Last Name must only contain letters" },
				{ "12.778", "Last Name must only contain letters" }, { " ", "First Name is required" },
				{ "K.lops", "First Name is required" } };
	}

	@Test(dataProvider = "invalidlastNameProvider")
	public void passesInvalidLastname(String Lastname, String expectedMsg) throws InterruptedException {
		SignInPage signinPage = new SignInPage(driver);
		String validationErrorMsg = signinPage.navigateToIagreePage().clickToAgree().setFName(Lastname).nexBtnHasError()
				.getValidationText();

		// Assert
		boolean validation = validationErrorMsg.contains(expectedMsg);
		Assert.assertTrue(validation);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
