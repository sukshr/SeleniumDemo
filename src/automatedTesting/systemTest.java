package automatedTesting;

import java.security.PublicKey;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class systemTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\HP\\\\Desktop\\\\selenium softwares\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
				
		driver.get("https://www.apply.okhca.org/Site/UserAccountLogin.aspx");
		driver.manage().window().maximize();
		
		
		AccountNew(driver);
		agreementPage(driver);
		enter(driver);
		FirstName(driver);
		
	}

	public static void AccountNew(WebDriver driver) throws InterruptedException {
	WebElement createNewAccount = driver.findElement(By.linkText("create a new account"));
	createNewAccount.click();
	
	Thread.sleep(5000);
	((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
	}
	
	
	public static void agreementPage(WebDriver driver) throws InterruptedException {
		
		WebElement agreement = driver.findElement(By.id("ctl00_cphStepPageData_rblAgree_0"));
		agreement.click();
	Thread.sleep(5000);
		
	}
	
	public static void enter(WebDriver driver) throws InterruptedException {
		WebElement clickling = driver.findElement(By.id("ctl00_cphStepPageData_lblStart"));
		clickling.click();
		Thread.sleep(5000);
	}
public static void FirstName(WebDriver driver) throws InterruptedException {
	driver.findElement(By.name("ctl00$cphStepPageData$txtFirstName")).sendKeys("Gilly");
	Thread.sleep(500);
	
	
	driver.findElement(By.name("ctl00$cphStepPageData$txtLastName")).sendKeys("Singh");
	Thread.sleep(500);
	

	WebElement RomanNumber = driver.findElement(By.name("ctl00$cphStepPageData$ddlSuffix"));
	Thread.sleep(500);
	Select selectROman = new Select(RomanNumber);
	selectROman.selectByVisibleText("VII");
	
	driver.findElement(By.id("ctl00_cphStepPageData_rblGender_0")).click();
	
}


}


