package features.EmailTemplateDownload;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import model.OperatingSystem;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Steps;
import steps.UserStepsForEmailDownload;
import utility.GenericClass;

@Narrative(text={"In order to send a Template Email with pre filled content",                      
        "As a Content Manager",
        "I want to download my Email Templates in OFT and HTML Format"})

@RunWith(SerenityRunner.class)  
public class EmailTemplateDownloadByContentManagerScope {
	
	GenericClass genericFunctions;
	String default_TemplateEmailName ="Email Template To Test HTML";
	
	@Steps
	UserStepsForEmailDownload structuredWebUser;	
	
	@Managed
    WebDriver driver;
	
	@Test
	@Issue("SW-6386")
	public void shouldBeAbleToDownloadEmailTemplateAsHtmlAndOftFromContentManager() throws InterruptedException, IOException
	{
		String templateEmailName = default_TemplateEmailName + " " +  genericFunctions.getCurrentDateTime();
		String expectedTemplateEmailName = templateEmailName.replaceAll("[ /:]+", "_");
		
		//Given
		structuredWebUser.isOnStructuredWebHomePage();
		
		//When
		structuredWebUser.entersSiteID("48482", "Structured Web Account");
		structuredWebUser.clicksOnLogin();
		structuredWebUser.selectTheRoleAs("Content Manager");
		structuredWebUser.clickOnTemplatesTab();
		structuredWebUser.clickEmailSubTab();
		structuredWebUser.clickNewEmailTemplate();
		structuredWebUser.enterEmailTemplateName(templateEmailName);
		structuredWebUser.enterEmailTemplateDescription("This is a template email to test");
		structuredWebUser.clickSaveEmailTemplate();
		structuredWebUser.enterEmailTemplateContent("This is the content to be written in editor");
		structuredWebUser.clickSaveEmailTemplate();
		structuredWebUser.clickTacticsTab();
		structuredWebUser.clickEmailSubTab();
		structuredWebUser.clickNewlyCreatedEmailTemplate(templateEmailName);
		structuredWebUser.enterTemplateSubjectLine("This is a subject line for Email Template");
		structuredWebUser.clickOnSaveAndRefreshPreview();	
		structuredWebUser.clickDownloadHTML();
		structuredWebUser.clickDownloadOFT();
		
		//Then
		if(genericFunctions.getOperaingSystem().equals(OperatingSystem.OS_WINDOWS))
		{
		structuredWebUser.shouldBeAbleToSeeSameContentInBothHtmlAndOft(expectedTemplateEmailName,genericFunctions.getDownloadPath());
		}
		else if (genericFunctions.getOperaingSystem().equals(OperatingSystem.OS_MAC_OS))
		{
			structuredWebUser.shouldBeAbleToDownloadAsHtmlWithFileNameAtPath(expectedTemplateEmailName,genericFunctions.getDownloadPath());
			structuredWebUser.shouldBeAbleToDownloadAsOftWithFileNameAtPath(expectedTemplateEmailName,genericFunctions.getDownloadPath());
		}
	}
}