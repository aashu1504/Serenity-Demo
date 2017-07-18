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
    
	public void clickTemplateTab() {
		templateTab.click();
	}

	public void clickEmailSubTab() {
		emailSubTab.click();
	}

	public void clickTacticsTab() {
		tacticsTab.click();
	}
}
