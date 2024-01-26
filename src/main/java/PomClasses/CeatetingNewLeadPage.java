package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CeatetingNewLeadPage {
	
	public CeatetingNewLeadPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy()
	private WebElement leadSolutationDropDown;
	
	@FindBy()
	private WebElement leadfirstName;
	@FindBy()
	private WebElement lastName;
	@FindBy()
	private WebElement companyname;
	@FindBy()
	private WebElement leadAssignTogroupRadioButton;
	@FindBy()
	private WebElement leadAssignTODropDown;
	@FindBy()
	private WebElement saveButton;
	
	public void selectSalutaion(String value) {
		Select s = new Select(leadSolutationDropDown);
		s.selectByValue(null);
	}
	public void leadFirstName(String firstnamae)
	{
		 leadfirstName.sendKeys(firstnamae );
	}
	public void leadLastName(String lastname)
	{
		lastName.sendKeys(lastname);
	}
	public void companyName(String companyName)
	{
		companyname.sendKeys(companyName);
	}
	
	public void leadAssignTogroupRadioButton()
	{
		leadAssignTogroupRadioButton.click();
	}
	public void leadassignDropDown()
	{
		leadAssignTODropDown.clear();
	}
	public void saveButton()
	{
		saveButton.click();
	}

}
