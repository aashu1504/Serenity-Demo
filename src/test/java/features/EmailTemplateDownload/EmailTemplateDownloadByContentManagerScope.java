package features.EmailTemplateDownload;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import model.OperatingSystem;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.ClearCookiesPolicy;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Steps;
import steps.UserStepsForCreatingNonTemplateEmailTactics;
import steps.UserStepsForCreatingTemplateEmailTactics;
import steps.UserStepsForDownloadAndVerification;
import steps.UserStepsForLoginToAVendorAccount;
import steps.UserStepsForNavigation;
import utility.GenericClass;

@Narrative(text={"In order to send a Template Email with pre filled content",                      
        "As a Content Manager",
        "I want to download my Email Templates in OFT and HTML Format"})

@RunWith(SerenityRunner.class)  
public class EmailTemplateDownloadByContentManagerScope {
	
	GenericClass genericFunctions;
	String default_TemplateEmailName ="Email Template To Test HTML";
	
	@Steps
	UserStepsForDownloadAndVerification downloadAndVerify;
	@Steps
	UserStepsForLoginToAVendorAccount loginToAVendorAccount;	
	@Steps
	UserStepsForNavigation userNavigationSteps;
	@Steps
	UserStepsForCreatingTemplateEmailTactics createTemplateEmail;
	@Steps
	UserStepsForCreatingNonTemplateEmailTactics createNonTemplateEmail;
	
	@Managed(clearCookies=ClearCookiesPolicy.BeforeEachTest)
    WebDriver driver;
	
	@Test
	@Issue("SW-6386")
	public void verifyETemplateDownloadFilesWithoutLandingPageFromContentManager() throws InterruptedException, IOException
	{
		String templateEmailName = default_TemplateEmailName + " " +  genericFunctions.getCurrentDateTime();
		String expectedTemplateEmailName = templateEmailName.replaceAll("[ /:]+", "_");
		
		//Given
		loginToAVendorAccount.isOnStructuredWebHomePage();
		
		//When
		loginToAVendorAccount.entersSiteID("48482", "Structured Web Account");
		loginToAVendorAccount.clicksOnLogin();
		loginToAVendorAccount.selectTheRoleAs("Content Manager");
		userNavigationSteps.clickOnTemplatesTab();
		userNavigationSteps.clickEmailSubTab();
		createTemplateEmail.clickNewEmailTemplate();
		createTemplateEmail.enterEmailTemplateName(templateEmailName);
		createTemplateEmail.enterEmailTemplateDescription("This is a template email to test");
		createTemplateEmail.clickSaveEmailTemplate();
		createTemplateEmail.enterEmailTemplateContent("This is the content to be written in editor");
		createTemplateEmail.clickSaveEmailTemplate();
		userNavigationSteps.clickTacticsTab();
		userNavigationSteps.clickEmailSubTab();
		createNonTemplateEmail.clickNewlyCreatedEmailTemplate(templateEmailName);
		createNonTemplateEmail.enterTemplateSubjectLine("This is a subject line for Email Template");
		createNonTemplateEmail.clickOnSaveAndRefreshPreview();	
		downloadAndVerify.clickEmailTemplateDownloadButtonToChooseDownloadType();
		downloadAndVerify.clickDownloadHTML();
		downloadAndVerify.clickEmailTemplateDownloadButtonToChooseDownloadType();
		downloadAndVerify.clickDownloadOFT();
		
		//Then
		if(genericFunctions.getOperaingSystem().equals(OperatingSystem.OS_WINDOWS))
		{
			downloadAndVerify.shouldBeAbleToSeeSameContentInBothHtmlAndOft(expectedTemplateEmailName,genericFunctions.getDownloadPath());
		}
		else if (genericFunctions.getOperaingSystem().equals(OperatingSystem.OS_MAC_OS))
		{
			downloadAndVerify.shouldBeAbleToDownloadAsHtmlWithFileNameAtPath(expectedTemplateEmailName,genericFunctions.getDownloadPath());
			downloadAndVerify.shouldBeAbleToDownloadAsOftWithFileNameAtPath(expectedTemplateEmailName,genericFunctions.getDownloadPath());
		}
	}
}