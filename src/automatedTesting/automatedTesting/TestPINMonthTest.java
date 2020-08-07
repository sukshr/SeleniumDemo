package automatedTesting.automatedTesting;

import org.testng.annotations.Test;
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
		getin.NavigatestoPINPage().monthdropdown().contirnuebtn();

	}

	@Test
	public void Enter_invalid_data() {
		SignInPage getin = new SignInPage(driver);
		getin.NavigatestoPINPage().yeardropdown().contirnuebtn();

	}

	@Test
	public void Enter_null_data() {
		SignInPage getin = new SignInPage(driver);
		getin.NavigatestoPINPage().datedropdown().contirnuebtn();

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
