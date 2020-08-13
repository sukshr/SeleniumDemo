package test;

import org.testng.annotations.Test;

import page.object.SignInPage;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterTest;

public class TestPINPage {
	WebDriver driver;

	
	@DataProvider(name = "validPINNumberProvider")
    public Object[][] dataProviderMethod() {
        return new Object[][] { { "ss345","SSN last 4 is required" }, { "@happysingh1768","SSN last 4 is required" }
        , { "..77omk","SSN last 4 is required" }, { "!!!!!","SSN last 4 is required" } };
    }
 
	@Test(dataProvider = "validPINNumberProvider")
	public void Enters_PIN_Number(String Pinnumber, String errorexpected) throws InterruptedException {
		// Arrange

		// Act
		SignInPage getin = new SignInPage(driver);
		String validationMsg = getin.navigatesToPINPage().pinNumber(Pinnumber).continuebtnHasError().getValidationErrorText();
		// Assert

		boolean validation = validationMsg.contains(errorexpected);
		Assert.assertTrue(validation);
		;
	}
	
	
	

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\HP\\\\Desktop\\\\selenium softwares\\\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://www.apply.okhca.org/Site/UserAccountLogin.aspx");
		driver.manage().window().maximize();
	}
	

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	

}
