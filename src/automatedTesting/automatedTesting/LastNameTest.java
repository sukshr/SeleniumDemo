package automatedTesting.automatedTesting;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class LastNameTest {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\HP\\\\Desktop\\\\selenium softwares\\\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://www.apply.okhca.org/Site/UserAccountLogin.aspx");
		driver.manage().window().maximize();
	}

	@Test
	public void Passes_valid_name() throws InterruptedException {
		SignInPage signinPage = new SignInPage(driver);
		signinPage.NavigateToIagreePage().ClickToAgree().SetLName("Singylingyface").NextBtn();

		// Assert
		WebElement validationtext = driver.findElement(By.id("ctl00_pnlValidatorSummary"));
		boolean validation = validationtext.getText().contains("First Name is required");
		Assert.assertTrue(validation);
	}
	@Test
	public void Passes_null() throws InterruptedException {
		SignInPage signinPage = new SignInPage(driver);
		signinPage.NavigateToIagreePage().ClickToAgree().NextBtn();

		// Assert
		WebElement validationtext = driver.findElement(By.id("ctl00_pnlValidatorSummary"));
		boolean validation = validationtext.getText().contains("First Name is required");
		Assert.assertTrue(validation);
	}


	@Test
	public void Passes_invalid_name() throws InterruptedException {
		SignInPage signinPage = new SignInPage(driver);
		signinPage.NavigateToIagreePage().ClickToAgree().SetLName("4529863256").NextBtn();

		// Assert
		WebElement validationtext = driver.findElement(By.id("ctl00_pnlValidatorSummary"));
		boolean validation = validationtext.getText().contains("Last Name must only contain letters");
		Assert.assertTrue(validation);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	

}
