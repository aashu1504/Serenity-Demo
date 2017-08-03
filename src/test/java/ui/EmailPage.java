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
	WebElement emailDownloadButton;
	
	@FindBy(xpath=".//button[@name='New_Email']")
	WebElement createNewEmailButton;
	
	@FindBy(xpath=".//img[@src='/sw_ap2/themes/5/images/blank.gif']")
	WebElement createNewContent; 
	
	@FindBy(xpath = ".//*[@id='campaignNameInput']")
    WebElement enterEmailName;
	
	@FindBy(xpath = ".//*[@id='campaignDescriptionInput']")
    WebElement enterEmailDescription;
	
	@FindBy(xpath = ".//*[@id='SaveNew']")
    WebElement saveEmailNameAndDescriptionButton;

	
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

	public void clickCreateNewEmailButton() {
		createNewEmailButton.click();
	}

	public void clickCreateNewContent() {
		createNewContent.click();
	}
	
	public void enterEmailName(String emailName) {
		enterEmailName.sendKeys(emailName);
	}
	
	public void enterEmailDescription(String emailDescription) {
		enterEmailDescription.sendKeys(emailDescription);
	}
	
	public void clickSaveEmailNameAndDescription() {
		saveEmailNameAndDescriptionButton.click();
	}

	public void clickEmailDownloadButtonToChooseDownloadType() {
		emailDownloadButton.click();
	}
}
