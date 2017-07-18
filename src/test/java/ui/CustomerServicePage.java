package ui;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;

public class CustomerServicePage extends PageObject{

	@FindBy(xpath = ".//span[contains(.,'Site ID:')]/input")
    WebElement siteIDTextField;
	
	@FindBy(xpath = ".//a[contains(.,'Login')]")
    WebElement loginButton;

	public void entersSiteID(String siteID) {
		siteIDTextField.sendKeys(siteID);
		siteIDTextField.sendKeys(Keys.ENTER);
	}

	public void clickLogin() {
		loginButton.click();	
	}
}
