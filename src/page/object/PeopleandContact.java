package page.object;

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

//TODO: ALl methods name has to be pasclasCase
public PeopleandContact firstaddressline(String addressLine) throws InterruptedException {
	Thread.sleep(5000);
	address.sendKeys(addressLine);
	return this;
}
public PeopleandContact seconeaddressline(String addressLine)  {
	
	secondaddress.sendKeys(addressLine);
	return this;

}
public PeopleandContact setCity(String city)  {
	cityaddress.sendKeys(city);
	return this;
}
public PeopleandContact stateDropdown(String state)  {
	 new Select(state).selectByVisibleText(state);

	return this;
}
public PeopleandContact setZipcode(String zipCode)  {
	codezip.sendKeys(zipCode);
	return this;
}
public PeopleandContact setMailingaddress()  {
	mailingadd.click();
	return this;
}
public PeopleandContact setLanguage(String language)  {
	 new Select(householdlanguage).selectByVisibleText(language);

	return this;
}
public PeopleandContact setWrittenCommunication(String spokenLanguage)  {
	 new Select(communication).selectByVisibleText(spokenLanguage);

	return this;
}
public PeopleandContact setCommunicationchoice()  {
	 new Select(electroniccommunication).selectByVisibleText("Letter");

	return this;
}
public PeopleandContact setEmailaddress(String email)  {
	electronicmail.sendKeys(email);
	return this;
}
public PeopleandContact setAuthorization()  {
	authorizedperson.click();
	return this;
}
public PeopleandContact nextButton()  {
	nextbtn.click();
	return this;
}

}
