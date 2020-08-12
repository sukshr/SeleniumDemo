package automatedTesting.automatedTesting;

import org.testng.annotations.Test;

import PageObject.SignInPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class IAgreeTest {
	WebDriver driver;


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
	
	@Test()
	public void Sucessfully_Navigates_To_Login_Page() {
		// Arrange

		// Act

		// Assert
		
	 Assert.assertEquals(driver.getTitle(), "Log On or Create Your Account");
		

	}
	@Test
	public void Sucessfully_Navigates_DemographicsPage() throws InterruptedException {
		// Arrange

		// Act
		SignInPage signinPage = new SignInPage(driver);
		signinPage.NavigateToIagreePage().ClickToAgree();

		// Assert
		
	 Assert.assertEquals(driver.getTitle(), "Step 1 - People & Contacts");
		
	}
	
	@Test
	public void Sucessfully_Navigates_To_LoginInPage_After_Disagree() {
		// Arrange

		// Act
		SignInPage signinPage = new SignInPage(driver);
		signinPage.NavigateToIagreePage().clickToDisagree();

		// Assert
		
	 Assert.assertEquals(driver.getTitle(), "Log On or Create Your Account");
		
	}
	@Test
	public void Sucessfully_Navigates_To_demographicPage() {
		// Arrange

		// Act
		SignInPage signinPage = new SignInPage(driver);
		signinPage.NavigateToIagreePage().clickToDisagree();

		// Assert
		
	 Assert.assertEquals(driver.getTitle(), "Log On or Create Your Account");
		
	 driver.quit();
	}	
	
}
	

	
	
