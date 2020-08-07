package automatedTesting.automatedTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {
	private WebDriver driver;

	public SignInPage(WebDriver _driver) {
		driver = _driver;
	}

	public IagreePage NavigateToIagreePage() {
		WebElement ele = driver.findElement(By.linkText("create a new account"));
		ele.click();
		return new IagreePage(driver);

	}
public PINPage NavigatestoPINPage() {
	WebElement pinaccount = driver.findElement(By.linkText("create an account using your PIN"));
	pinaccount.click();
	return new PINPage(driver);
}
}
