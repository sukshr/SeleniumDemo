package test;

import org.testng.annotations.Test;

import page.object.SignInPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
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
	@DataProvider(name = "invalidFirstNameProvider")
    public Object[][] dataProviderMethod() {
        return new Object[][] { { "1245896325","First Name must only contain letters" }, { "Gilly@","First Name must only contain letters" }
        , { "John.Doe","First Name must only contain letters" }, { "JohnDoe25","First Name must only contain letters" } };
    }
 
	@Test(dataProvider = "invalidFirstNameProvider")
	public void First_Name_Should_Only_Have_Letters(String firstName, String expectedError) throws InterruptedException {
		// Arrange

		// Act
		SignInPage signinPage = new SignInPage(driver);
		String validationMsg = signinPage.NavigateToIagreePage().ClickToAgree().SetFName(firstName).NexBtnHasError().GetValidationText();

		// Assert

		boolean validation = validationMsg.contains(expectedError);
		Assert.assertTrue(validation);
		;
	}

   
	
	@Test
	public void Enters_Valid_Name_In_FirstName_Field() throws InterruptedException {
		// Arrange

		// Act
		SignInPage signinPage = new SignInPage(driver);
		String validationMsg = signinPage.NavigateToIagreePage().ClickToAgree().SetFName("gillyGamerOnFaderHooJosie")
				.NexBtnHasError().GetValidationText();

		// Assert
		boolean validation = validationMsg.contains("Last Name is required");
		Assert.assertTrue(validation);

	}

	@Test
	public void Entering_numbers_In_firstName_field() throws InterruptedException {
		// Arrange

		// Act
		SignInPage signinPage = new SignInPage(driver);
		String validationMsg = signinPage.NavigateToIagreePage().ClickToAgree().SetFName("1245896325").NexBtnHasError().GetValidationText();

		// Assert

		boolean validation = validationMsg.contains("First Name must only contain letters.");
		Assert.assertTrue(validation);
		;
	}

	@Test
	public void Entering_nothing_In_firstName_field() throws InterruptedException {
		// Arrange

		// Act
		SignInPage signinPage = new SignInPage(driver);
		String validationMsg = signinPage.NavigateToIagreePage().ClickToAgree().NexBtnHasError().GetValidationText();

		// Assert
		
		boolean validation = validationMsg.contains("First Name is required");
		Assert.assertTrue(validation);
		;
//ToDO: should be om after test
		driver.quit();
	}

}
