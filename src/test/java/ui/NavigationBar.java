package ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;

public class NavigationBar extends PageObject{

	@FindBy(xpath = ".//*[@id='tab_Templates']/a")
    WebElement templateTab;
	
	@FindBy(xpath = ".//*[@id='subtab_Email']/a")
    WebElement emailSubTab;

    @FindBy(xpath = ".//*[@id='tab_Tactics']/a")
    WebElement tacticsTab;
    
    @FindBy(xpath = ".//*[@id='scopeActive']")
    WebElement dropdownMenu;
    
    @FindBy(xpath = ".//*[@id='Program_Manager']")
    WebElement clickPMRoleInList;
    
    @FindBy(xpath = ".//*[@id='Content_Manager']")
    WebElement clickCMRoleInList;
    
	public void clickTemplateTab() {
		templateTab.click();
	}

	public void clickEmailSubTab() {
		emailSubTab.click();
	}

	public void clickTacticsTab() {
		tacticsTab.click();
	}

	public void clickOnARole(String role) {
		if(role.equals("Program Manager"))
		{
			clickPMRoleInList.click();
		}
		else if (role.equals("Content Manager"))
		{
			clickCMRoleInList.click();
		}
	}

	public void clickonRoleDropdown() {
		dropdownMenu.click();
	}
}
