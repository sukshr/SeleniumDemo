package PageObject;

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
	WebElement LogOnBtn;
	

	public SignInPage(WebDriver _driver) {
		driver = _driver;
		PageFactory.initElements(driver, this);
	}

	public IagreePage NavigateToIagreePage() {
		ele.click();
		return new IagreePage(driver);

	}

	public PINPage NavigatestoPINPage() {
		WebElement pinaccount = driver.findElement(By.linkText("create an account using your PIN"));
		pinaccount.click();
		return new PINPage(driver);
	}

	public SignInPage EnterUsername(String name) {
		username.sendKeys(name);
		return this;
	}

	public SignInPage EnterPassword(String pass) {
		password.sendKeys(pass);
		return this;
	}
	public void ClickTOLoGON() throws InterruptedException {
		Thread.sleep(5000);
		LogOnBtn.click();
	}
}
