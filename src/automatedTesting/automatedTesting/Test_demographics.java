package automatedTesting.automatedTesting;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Test_demographics {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\HP\\\\Desktop\\\\selenium softwares\\\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://www.apply.okhca.org/Site/UserAccountLogin.aspx");
		driver.manage().window().maximize();
	}

	/*
	 * @AfterMethod public void afterMethod() { driver.quit(); }
	 */
	@Test
	public void Enters_Valid_Name_In_FirstName_Field() throws InterruptedException {
		// Arrange

		// Act
		SignInPage signinPage = new SignInPage(driver);
		signinPage.NavigateToIagreePage().ClickToAgree().SetFName("gillyGamerOnFaderHooJosie").NextBtn();

		// Assert
		WebElement validationtext = driver.findElement(By.id("ctl00_pnlValidatorSummary"));
		boolean validation = validationtext.getText().contains("Last Name is required");
		Assert.assertTrue(validation);
		
	}

	@Test
	public void Entering_numbers_In_firstName_field() throws InterruptedException {
		// Arrange

		// Act
		SignInPage signinPage = new SignInPage(driver);
		signinPage.NavigateToIagreePage().ClickToAgree().SetFName("1245896325").NextBtn();

		// Assert
		WebElement validationtext = driver.findElement(By.id("ctl00_pnlValidatorSummary"));
		boolean validation = validationtext.getText()
				.toLowerCase().contains("First Name must only contain letters.".toLowerCase());
		Assert.assertTrue(validation);
		;
	}
	@Test
	public void Entering_nothing_In_firstName_field() throws InterruptedException {
		// Arrange

		// Act
		SignInPage signinPage = new SignInPage(driver);
		signinPage.NavigateToIagreePage().ClickToAgree().NextBtn();

		// Assert
		WebElement validationtext = driver.findElement(By.id("ctl00_pnlValidatorSummary"));
		boolean validation = validationtext.getText().contains("First Name is required");
		Assert.assertTrue(validation);
		;
	
		driver.quit();
	}

}