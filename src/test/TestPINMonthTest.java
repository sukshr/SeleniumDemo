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
	public void Enter_valid_data() {
		SignInPage getin = new SignInPage(driver);
		getin.navigatesToPINPage().monthDropdown("June").contirnuebtn();

	}

	@Test
	public void Enter_invalid_data() {
		SignInPage getin = new SignInPage(driver);
		getin.navigatesToPINPage().yearDropdown("1990").contirnuebtn();

	}

	@Test
	public void Enter_null_data() {
		SignInPage getin = new SignInPage(driver);
		getin.navigatesToPINPage().dateDropdown("14").contirnuebtn();

	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\HP\\\\Desktop\\\\selenium softwares\\\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://www.apply.okhca.org/Site/UserAccountLogin.aspx");
		driver.manage().window().maximize();
	
	}


}
