package PomClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

//Dynamic path
public class LeadsInformationPage {
	 WebDriver driver;
	public LeadsInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver , this);
		this.driver= driver;
	}
	public void verifyLeadInformation(String frstname , String lastname)
	{
		driver.findElement(By.xpath(null));
	}

}
