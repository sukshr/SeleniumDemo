package PageObject;

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

	public PINPage(WebDriver _driver) {
		driver = _driver;
		PageFactory.initElements(driver, this);
	}

	public PINPage pinnumber(String number) {
		PINNumber.sendKeys(number);
		return this;
	}

	public PINPage ssnnumber(String nbr) {
		SSNNumber.sendKeys(nbr);
		return this;
	}

	public PINPage monthdropdown() {
		Select dropdown = new Select(Month);
		dropdown.selectByVisibleText("July");
		return this;
	}

	public PINPage datedropdown() {
		Select ddropdown = new Select(Date);
		ddropdown.selectByVisibleText("11");
		return this;
	}

	public PINPage yeardropdown() {
		Select ydropdown = new Select(Year);
		ydropdown.selectByVisibleText("2018");
		return this;
	}

	public void contirnuebtn() {
		Continue.click();
	

	}
}
