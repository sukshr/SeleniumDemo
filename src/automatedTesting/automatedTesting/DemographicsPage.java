package automatedTesting.automatedTesting;

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
	WebElement FirstName;
	@FindBy(id = "ctl00_cphStepPageData_txtLastName")
	WebElement LastName;
	@FindBy(id = "ctl00_cphStepPageData_ddlSuffix")
	WebElement dropdown;
	@FindBy(id = "ctl00_cphStepPageData_dteBirthDate_ddlMonth")
	WebElement monthdropdown;
	@FindBy(id = "ctl00_cphStepPageData_dteBirthDate_ddlDay")
	WebElement daydropdown;
	@FindBy(id = "ctl00_cphStepPageData_dteBirthDate_ddlYear")
	WebElement yeardropdown;
	@FindBy(id = "ctl00_cphStepPageData_ddlMaritalStatus")
	WebElement maratialstatus;
	@FindBy(id = "ctl00_cphStepPageData_rblGender_1")
	WebElement gender;
	@FindBy(id = "ctl00_cphStepPageData_rblPregnant_1")
	WebElement pregnant;
	@FindBy(id = "ctl00_cphStepPageData_cblSC_0")
	WebElement checkboxes;
	@FindBy(id = "ctl00_cphStepPageData_cblRace_1")
	WebElement race;
	@FindBy(id = "ctl00_cphStepPageData_rblTypeUSCitizen_0")
	WebElement citizenshipstatus;
	@FindBy(id = "ctl00_cphStepPageData_ddlUSDoc")
	WebElement documentationtype;
	@FindBy(id = "ctl00_cphStepPageData_rblLiveOkl_1")
	WebElement residence;
	@FindBy(id = "ctl00_cphStepPageData_txtSSN1")
	WebElement ssnnumber;
	@FindBy(id = "ctl00_cphStepPageData_lblNext")
	WebElement nextbutton;
	@FindBy(id = "ctl00_pnlValidatorSummary")
	WebElement validationsummaryDemographics;

	public DemographicsPage(WebDriver driver2) throws InterruptedException {
		driver = driver2;
		Thread.sleep(3000);
		PageFactory.initElements(driver, this);

	}

	public DemographicsPage SetFName(String fName) {
		FirstName.sendKeys(fName);
		return this;
	}

	public DemographicsPage SetLName(String lName) {
		LastName.sendKeys(lName);
		return this;
	}

	public DemographicsPage SetSuffix() {
		new Select(dropdown).selectByVisibleText("V");
		return this;
	}

	public DemographicsPage Setmonth() {
		new Select(monthdropdown).selectByVisibleText("June");
		return this;
	}

	public DemographicsPage Setday() {
		new Select(daydropdown).selectByVisibleText("11");
		return this;
	}

	public DemographicsPage SetYear() {
		new Select(yeardropdown).selectByVisibleText("1992");
		return this;
	}

	public DemographicsPage SetMaratialStatus() {
		new Select(maratialstatus).selectByVisibleText("Married, whether living together or involuntarily separated");
		return this;
	}

	public DemographicsPage GenderButton() {
		gender.click();
		return this;
	}

	public DemographicsPage PregnantButton() {
		pregnant.click();
		return this;
	}

	public DemographicsPage RequestedBenefit() {
		checkboxes.click();
		return this;
	}

	public DemographicsPage RaceIdentity() {
		race.click();
		return this;
	}

	public DemographicsPage CitizenIdentity() {
		citizenshipstatus.click();
		return this;
	}

	public DemographicsPage SetDcoumentationType() {
		new Select(documentationtype).selectByVisibleText("U.S. Birth Certificate (Original or Certified Copy)");
		return this;
	}

	public DemographicsPage SetResidency() {
		residence.click();
		return this;
	}

	public DemographicsPage SetSsn(String ssn) {
		ssnnumber.sendKeys(ssn);
		return this;
	}

	public PeopleandContact NextBtn() throws InterruptedException {
		nextbutton.click();
		return new PeopleandContact(driver);
	}

	public DemographicsPage NexBtnHasError() {
		nextbutton.click();
		return this;
	}

	public String GetValidationText() {
		return validationsummaryDemographics.getText();
	}

}
