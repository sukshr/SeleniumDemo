package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IAgreePage {
	private WebDriver driver;
	@FindBy(id = "ctl00_cphStepPageData_rblAgree_1")
	WebElement clickDisagree;
	@FindBy(id = "ctl00_cphStepPageData_btnExit")
	WebElement exitBtn;
	@FindBy(id = "ctl00_cphStepPageData_rblAgree_0")
	WebElement clickAgree;
	@FindBy(id = "ctl00_cphStepPageData_lblStart")
	WebElement clickSubmit;

	public IAgreePage(WebDriver _driver) {
		driver = _driver;
		PageFactory.initElements(driver, this);
	}

	public DemographicsPage clickToAgree() throws InterruptedException {
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		clickAgree.click();
		Thread.sleep(3000);
		clickSubmit.click();

		return new DemographicsPage(driver);
	}

	public SignInPage clickToDisagree() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		clickDisagree.click();
		exitBtn.click();
		return new SignInPage(driver);

	}

}
