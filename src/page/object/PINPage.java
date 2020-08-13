package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PINPage {
	WebDriver driver;
	@FindBy(id = "ctl00_cphStepPageData_txtPIN")
	WebElement PINNumber;
	@FindBy(id = "ctl00_cphStepPageData_txtSSN4")
	WebElement SSNNumber;
	@FindBy(id = "ctl00_cphStepPageData_ucDOB_ddlMonth")
	WebElement Month;
	@FindBy(id = "ctl00_cphStepPageData_ucDOB_ddlDay")
	WebElement Date;
	@FindBy(id = "ctl00_cphStepPageData_ucDOB_ddlYear")
	WebElement Year;
	@FindBy(id = "ctl00_cphStepPageData_lblContinue")
	WebElement Continue;
	@FindBy(id = "ctl00_pnlValidatorSummary")
	WebElement validationsummary;

	public PINPage(WebDriver _driver) {
		driver = _driver;
		PageFactory.initElements(driver, this);
	}

	public PINPage pinNumber(String number) {
		PINNumber.sendKeys(number);
		return this;
	}

	public PINPage ssnNumber(String nbr) {
		SSNNumber.sendKeys(nbr);
		return this;
	}

	public PINPage setMonthDropdown(String month) {
		Select dropdown = new Select(Month);
		dropdown.selectByVisibleText(month);
		return this;
	}

	public PINPage setDateDropdown(String date) {
		Select ddropdown = new Select(Date);
		ddropdown.selectByVisibleText(date);
		return this;
	}

	public PINPage yearDropdown(String year) {
		Select ydropdown = new Select(Year);
		ydropdown.selectByVisibleText(year);
		return this;
	}

	public void continuebtn() {
		Continue.click();

	}

	public PINPage continuebtnHasError() {
		Continue.click();
		return this;
	}

	public String getValidationErrorText() {
		return validationsummary.getText();
	}
}
