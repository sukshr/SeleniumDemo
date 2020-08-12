package automatedTesting.automatedTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PeopleandContact {
WebDriver driver;

@FindBy(id="ctl00_cphStepPageData_txtResAddStreetLine1")
WebElement address;
@FindBy(id="ctl00_cphStepPageData_txtResAddStreetLine2")
WebElement secondaddress;
@FindBy(id="ctl00_cphStepPageData_txtResAddCity")
WebElement cityaddress;
@FindBy(id="ctl00_cphStepPageData_ddlResAddressStateList")
WebElement state;
@FindBy(id="ctl00_cphStepPageData_txtResZipCode")
WebElement codezip;
@FindBy(id="ctl00_cphStepPageData_chkSameAsRes")
WebElement mailingadd;
@FindBy(id="ctl00_cphStepPageData_ddlLang")
WebElement householdlanguage;
@FindBy(id="ctl00_cphStepPageData_ddlLangWritt")
WebElement communication;
@FindBy(id="ctl00_cphStepPageData_ddlElectNotice")
WebElement electroniccommunication;
@FindBy(id="ctl00_cphStepPageData_txtAppEMail")
WebElement electronicmail;
@FindBy(id="ctl00_cphStepPageData_rblShowAuthRep_0")
WebElement authorizedperson;
@FindBy(id="ctl00_cphStepPageData_btnNext")
WebElement nextbtn;



public PeopleandContact(WebDriver _driver) throws InterruptedException{
	driver = _driver;
	Thread.sleep(3000);
    PageFactory.initElements(driver, this);
}

public PeopleandContact firstaddressline(String fline) throws InterruptedException {
	Thread.sleep(5000);
	address.sendKeys(fline);
	return this;
}
public PeopleandContact seconeaddressline(String Sline)  {
	
	secondaddress.sendKeys(Sline);
	return this;

}
public PeopleandContact City(String cities)  {
	cityaddress.sendKeys(cities);
	return this;
}
public PeopleandContact Statedropdown()  {
	 new Select(state).selectByVisibleText("Texas");

	return this;
}
public PeopleandContact Zipcode(String Zcode)  {
	codezip.sendKeys(Zcode);
	return this;
}
public PeopleandContact mailingaddress()  {
	mailingadd.click();
	return this;
}
public PeopleandContact language()  {
	 new Select(householdlanguage).selectByVisibleText("English");

	return this;
}
public PeopleandContact writtencommunication()  {
	 new Select(communication).selectByVisibleText("English");

	return this;
}
public PeopleandContact communicationchoice()  {
	 new Select(electroniccommunication).selectByVisibleText("Letter");

	return this;
}
public PeopleandContact emailaddress(String email)  {
	electronicmail.sendKeys(email);
	return this;
}
public PeopleandContact authorization()  {
	authorizedperson.click();
	return this;
}
public PeopleandContact nextbutton()  {
	nextbtn.click();
	return this;
}

}
