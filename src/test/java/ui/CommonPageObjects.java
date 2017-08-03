package ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;

public class CommonPageObjects extends PageObject{

	@FindBy(xpath=".//ul[@class='dropdown-menu']/li[1]/a[contains(.,'HTML')]")
	WebElement downloadHTML;
	
	@FindBy(xpath=".//ul[@class='dropdown-menu']/li[2]/a[contains(.,'OFT')]")
	WebElement downloadOFT;
	
	public void clickDownloadHTMLButton() {
		downloadHTML.click();
	}
	
	public void clickDownloadOFTButton() {
		downloadOFT.click();
	}
}
