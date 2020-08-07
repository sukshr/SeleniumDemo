package automatedTesting.automatedTesting;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PINPage {
WebDriver driver;

public PINPage (WebDriver _driver) {
	driver = _driver;
	PageFactory.initElements(driver, this);
}

public PINPage pinnumber(String number) {
	driver.findElement(By.id("ctl00_cphStepPageData_txtPIN")).sendKeys(number);
	return this;
	}

public PINPage ssnnumber(String nbr) {
driver.findElement(By.id("ctl00_cphStepPageData_txtSSN4")).sendKeys(nbr);
return this;
}

public PINPage monthdropdown () {
	WebElement dob = driver.findElement(By.id("ctl00_cphStepPageData_ucDOB_ddlMonth"));
	Select dropdown = new Select(dob);
			dropdown.selectByVisibleText("July");
			return this;
}
public PINPage datedropdown () {
	WebElement day = driver.findElement(By.id("ctl00_cphStepPageData_ucDOB_ddlDay"));
	Select ddropdown = new Select(day);
			ddropdown.selectByVisibleText("11");
			return this;
}
public PINPage yeardropdown() {
	WebElement year = driver.findElement(By.id("ctl00_cphStepPageData_ucDOB_ddlYear"));
	Select ydropdown = new Select(year);
			ydropdown.selectByVisibleText("2018");
			return this;
}
public PINPage contirnuebtn() {
driver.findElement(By.id("ctl00_cphStepPageData_lblContinue")).click();
return this;

}
}

