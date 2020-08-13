package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DemographicsPage {
	private WebDriver driver;

	@FindBy(name = "ctl00$cphStepPageData$txtFirstName")
	WebElement firstName;
	@FindBy(id = "ctl00_cphStepPageData_txtLastName")
	WebElement lastName;
	@FindBy(id = "ctl00_cphStepPageData_ddlSuffix")
	WebElement dropDown;
	@FindBy(id = "ctl00_cphStepPageData_dteBirthDate_ddlMonth")
	WebElement monthdropDown;
	@FindBy(id = "ctl00_cphStepPageData_dteBirthDate_ddlDay")
	WebElement daydropDown;
	@FindBy(id = "ctl00_cphStepPageData_dteBirthDate_ddlYear")
	WebElement yeardropDown;
	@FindBy(id = "ctl00_cphStepPageData_ddlMaritalStatus")
	WebElement maratialStatus;
	@FindBy(id = "ctl00_cphStepPageData_rblGender_1")
	WebElement gender;
	@FindBy(id = "ctl00_cphStepPageData_rblPregnant_1")
	WebElement pregnant;
	@FindBy(id = "ctl00_cphStepPageData_cblSC_0")
	WebElement checkBoxes;
	@FindBy(id = "ctl00_cphStepPageData_cblRace_1")
	WebElement race;
	@FindBy(id = "ctl00_cphStepPageData_rblTypeUSCitizen_0")
	WebElement citizenshipStatus;
	@FindBy(id = "ctl00_cphStepPageData_ddlUSDoc")
	WebElement documentationType;
	@FindBy(id = "ctl00_cphStepPageData_rblLiveOkl_1")
	WebElement residence;
	@FindBy(id = "ctl00_cphStepPageData_txtSSN1")
	WebElement ssnNumber;
	@FindBy(id = "ctl00_cphStepPageData_lblNext")
	WebElement nextButton;
	@FindBy(id = "ctl00_pnlValidatorSummary")
	WebElement validationSummaryDemographics;

	public DemographicsPage(WebDriver _driver) throws InterruptedException {
		driver = _driver;
		Thread.sleep(3000);
		PageFactory.initElements(driver, this);

	}

	public DemographicsPage setFName(String fName) {
		firstName.sendKeys(fName);
		return this;
	}

	public DemographicsPage setLName(String lName) {
		lastName.sendKeys(lName);
		return this;
	}
//TODO: make all the hardcoded values parameterized
	public DemographicsPage setSuffix(String value) {
		new Select(dropDown).selectByVisibleText(value);
		return this;
	}

	public DemographicsPage setMonth(String month) {
		new Select(monthdropDown).selectByVisibleText(month);
		return this;
	}

	public DemographicsPage setDay(String day) {
		new Select(daydropDown).selectByVisibleText(day);
		return this;
	}

	public DemographicsPage setYear(String year) {
		new Select(yeardropDown).selectByVisibleText(year);
		return this;
	}

	public DemographicsPage setMaratialStatus() {
		new Select(maratialStatus).selectByVisibleText("Married, whether living together or involuntarily separated");
		return this;
	}

	public DemographicsPage genderButton() {
		gender.click();
		return this;
	}

	public DemographicsPage pregnantButton() {
		pregnant.click();
		return this;
	}

	public DemographicsPage requestedBenefit() {
		checkBoxes.click();
		return this;
	}

	public DemographicsPage raceIdentity() {
		race.click();
		return this;
	}

	public DemographicsPage citizenIdentity() {
		citizenshipStatus.click();
		return this;
	}

	public DemographicsPage setDcoumentationTypeAsUSCitizen() {
		new Select(documentationType).selectByVisibleText("U.S. Birth Certificate (Original or Certified Copy)");
		return this;
	}

	public DemographicsPage setResidency() {
		residence.click();
		return this;
	}

	public DemographicsPage setSsn(String ssn) {
		ssnNumber.sendKeys(ssn);
		return this;
	}

	public PeopleandContact nextBtn() throws InterruptedException {
		nextButton.click();
		return new PeopleandContact(driver);
	}

	public DemographicsPage nexBtnHasError() {
		nextButton.click();
		return this;
	}

	public String getValidationText() {
		return validationSummaryDemographics.getText();
	}

}
