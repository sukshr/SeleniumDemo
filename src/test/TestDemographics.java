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

public class TestDemographics {
	WebDriver driver;
	

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\HP\\\\Desktop\\\\selenium softwares\\\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://www.apply.okhca.org/Site/UserAccountLogin.aspx");
		driver.manage().window().maximize();
	}

	
	@DataProvider(name = "invalidFirstNameProvider")
    public Object[][] dataProviderMethod() {
        return new Object[][] { { "1245896325","First Name must only contain letters" }, { "Gilly@","First Name must only contain letters" }
        , { "John.Doe","Last Name is required" }, { "JohnDoe25","First Name must only contain letters" } };
    }
 
	@Test(dataProvider = "invalidFirstNameProvider")
	public void firstNameShouldOnlyHaveLetters(String firstName, String expectedError) throws InterruptedException {
		// Arrange

		// Act
		SignInPage signinPage = new SignInPage(driver);
		String validationMsg = signinPage.navigateToIagreePage().clickToAgree().setFName(firstName).nexBtnHasError().getValidationText();

		// Assert

		boolean validation = validationMsg.contains(expectedError);
		Assert.assertTrue(validation);
		;
	}

   
	
	@DataProvider(name = "validFirstNameProvider")
    public Object[][] dataProviderMethodWithValidName() {
        return new Object[][] { { "Gilly","Last Name is required" }, { "Happy","Last Name is required" }
        , { "hap","Last Name is required" }, { "KILLMANINHOTSUMMERCOVIDSAD","Last Name is required" } };
    }
	@Test(dataProvider ="validFirstNameProvider" )
	public void Enters_Valid_Name_In_FirstName_Field(String firstname, String expectedmessage) throws InterruptedException {
		// Arrange

		// Act
		SignInPage signinPage = new SignInPage(driver);
		String validationMsg = signinPage.navigateToIagreePage().clickToAgree().setFName(firstname)
				.nexBtnHasError().getValidationText();

		// Assert
		boolean validation = validationMsg.contains(expectedmessage);
		Assert.assertTrue(validation);

	}


@AfterMethod
public void aftermethod() {
	driver.quit();
}
	
	
}
