package automatedTesting.automatedTesting;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\HP\\\\Desktop\\\\selenium softwares\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
				
		driver.get("https://www.apply.okhca.org/Site/UserAccountLogin.aspx");
		driver.manage().window().maximize();
		
		SignInPage getin = new SignInPage(driver);
		getin
		.NavigateToIagreePage()
		.ClickToAgree()
		.SetFName("Gilly")
		.SetLName("Singh")
		.SetSuffix()
		.Setmonth()
		.Setday()
		.SetYear()
		.SetMaratialStatus()
		.GenderButton()
		.PregnantButton()
		.RequestedBenefit()
		.RaceIdentity()
		.CitizenIdentity()
		.SetDcoumentationType()
		.SetResidency()
		.SetSsn("154248125154248125")
		.NextBtn()
		.firstaddressline("417 MockingJay Rd")
		.seconeaddressline("257 8th Street")
		.City("Ada")
		.Statedropdown()
		.Zipcode("58963")
		.mailingaddress()
		.language()
		.writtencommunication()
		.communicationchoice()
		.emailaddress("gilly.singh@test.com")
		.authorization()
		.nextbutton();
	
		
		
		
		driver.close();
		
		
		
	}

}
