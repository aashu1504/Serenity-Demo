package ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;

public class EmailTemplatePage extends PageObject{

	@FindBy(xpath = "html/body")
    WebElement contentEditor;
	
	@FindBy(xpath = ".//*[@name='Button_Save']")
    WebElement saveEmailTemplateButton;
	
	@FindBy(xpath = ".//textarea[@name='TemplateDesc']")
    WebElement enterEmailTemplateDescription;
	
	@FindBy(xpath = ".//button[@name='btn_Email']")
    WebElement clickNewEmailTemplate;
	
	@FindBy(xpath = ".//input[@name='TemplateName']")
    WebElement emailTemplateName;
	
	//.//*[@id='SearchResultsDiv']/table/tbody/tr[@valign="top"]/td[2]/span/a
	
	public void clickNewEmailTemplate() {
		clickNewEmailTemplate.click();
	}
	
	public void enterEmailTemplateName(String templateName) {
		emailTemplateName.sendKeys(templateName);
	}
	
	public void enterEmailTemplateDescription(String emailDescription) {
		enterEmailTemplateDescription.sendKeys(emailDescription);
	}
	
	public void clickSaveEmailTemplate() {
		saveEmailTemplateButton.click();
	}
	
	public void enterEmailTemplateContent(String emailTemplateContent) {
		contentEditor.sendKeys(emailTemplateContent);
	}
}
