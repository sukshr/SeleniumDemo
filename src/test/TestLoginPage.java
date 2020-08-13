package test;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import page.object.SignInPage;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestLoginPage {
	WebDriver driver;

	@FindBy(id = "ctl00_cphStepPageData_lblRegistrationCOde")
	WebElement registrationId;

	@org.testng.annotations.Parameters({ "username", "password" })

	@Test

	public void enterValidUserNamePassword(String username, String password) throws InterruptedException {
		SignInPage signinPage = new SignInPage(driver);
		signinPage.setUsername(username).setPassword(password).clickToLogon();

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
