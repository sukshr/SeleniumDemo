package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	private WebDriver driver;
	@FindBy(id = "ctl00_cphStepPageData_txtUserId")
	WebElement username;
	@FindBy(id = "ctl00_cphStepPageData_txtPassword")
	WebElement password;
	@FindBy(linkText = "create a new account")
	WebElement ele;
	@FindBy(id = "ctl00_cphStepPageData_lblOK")
	WebElement logOnBtn;
	

	public SignInPage(WebDriver _driver) {
		driver = _driver;
		PageFactory.initElements(driver, this);
	}

	public IAgreePage navigateToIagreePage() {
		ele.click();
		return new IAgreePage(driver);

	}

	public PINPage navigatesToPINPage() {
		WebElement pinaccount = driver.findElement(By.linkText("create an account using your PIN"));
		pinaccount.click();
		return new PINPage(driver);
	}

	public SignInPage setUsername(String name) {
		username.sendKeys(name);
		return this;
	}

	public SignInPage setPassword(String pass) {
		password.sendKeys(pass);
		return this;
	}
	public void clickToLogon() throws InterruptedException {
		Thread.sleep(5000);
		logOnBtn.click();
	}
}
