package ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;

public class EmailPage extends PageObject{

	@FindBy(xpath = ".//input[@name='Subject']")
    WebElement subjectLine;
	
	@FindBy(xpath=".//*[@id='Save2Button']")
	WebElement saveAndRefreshPreview;

	@FindBy(xpath=".//*[@id='SaveButtonRow1']/table/tbody/tr/td[5]/div/button")
	WebElement downloadButton;
	
	@FindBy(xpath=".//ul[@class='dropdown-menu']/li[1]/a[contains(.,'HTML')]")
	WebElement downloadHTML;
	
	@FindBy(xpath=".//ul[@class='dropdown-menu']/li[2]/a[contains(.,'OFT')]")
	WebElement downloadOFT;
	
	public void clickNewlyCreatedTemplate(String templateEmailName) {
		List<WebElement> allEmailTemplates = getDriver().findElements(By.xpath(".//*[@id='SearchResultsDiv']/table/tbody/tr[@valign='top']/td[2]/span/a"));
		for (WebElement emailTemplate: allEmailTemplates)
		{
			if(emailTemplate.getText().equals(templateEmailName + " - Default"))
			{
				emailTemplate.click();	
				break;
			}
		}
	}

	public void enterTemplateSubject(String subject) {
		subjectLine.clear();
		subjectLine.sendKeys(subject);
	}
	
	public void saveAndRefreshClick() {
		saveAndRefreshPreview.click();
	}

	public void clickDownloadHTMLButton() {
		downloadButton.click();
		downloadHTML.click();
	}
	
	public void clickDownloadOFTButton() {
		downloadButton.click();
		downloadOFT.click();
	}
}
