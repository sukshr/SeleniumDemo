package test;

import org.testng.annotations.Test;

import page.object.SignInPage;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestPINMonthTest {
	WebDriver driver;

	@Test
	public void enterValidData() {
		SignInPage getin = new SignInPage(driver);
		getin.navigatesToPINPage().setMonthDropdown("June").continuebtn();

	}

	@Test
	public void enterInvaliDdata() {
		SignInPage getin = new SignInPage(driver);
		getin.navigatesToPINPage().yearDropdown("1990").continuebtn();

	}

	@Test
	public void enterNullData() {
		SignInPage getin = new SignInPage(driver);
		getin.navigatesToPINPage().setDateDropdown("14").continuebtn();

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
