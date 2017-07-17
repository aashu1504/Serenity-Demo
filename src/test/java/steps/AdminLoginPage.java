package steps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;

public class AdminLoginPage extends PageObject{

	@FindBy(xpath = ".//input[@id='AppID18123']")
    WebElement selectProgramManagerRole;
	
	@FindBy(xpath = ".//label[.='Marketing Center']")
    WebElement selectMarketingCenterRole;
	
	@FindBy(xpath = "//label[.='Content Manager']")
    WebElement selectContentManagerRole;
	
	public void selectTheRole(String roleType) {
		if(roleType.equals("Program Manager"))
		{
			selectProgramManagerRole.click();		
		}
		else if(roleType.equals("Marketing Center"))
		{
			selectMarketingCenterRole.click();
		}
		else if(roleType.equals("Content Manager"))
		{
			selectContentManagerRole.click();
		}
	}

}
