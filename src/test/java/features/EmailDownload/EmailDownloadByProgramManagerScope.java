package features.EmailDownload;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import model.OperatingSystem;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.ClearCookiesPolicy;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import steps.UserStepsForCreatingNonTemplateEmailTactics;
import steps.UserStepsForCreatingTemplateEmailTactics;
import steps.UserStepsForDownloadAndVerification;
import steps.UserStepsForLoginToAVendorAccount;
import steps.UserStepsForNavigation;
import utility.GenericClass;

@RunWith(SerenityRunner.class) 
public class EmailDownloadByProgramManagerScope {
	
	GenericClass genericFunctions;
	String default_EmailName ="Email To Test HTML";

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
	public void verifyEmailDownloadFilesWithoutLandingPageFromProgramManager() throws IOException, InterruptedException
	{
		String emailName = default_EmailName + " " +  genericFunctions.getCurrentDateTime();
		String expectedEmailName = emailName.replaceAll("[ /:]+", "_");
		
		//Given
		loginToAVendorAccount.isOnStructuredWebHomePage();
		
		//When
		loginToAVendorAccount.entersSiteID("48482", "Structured Web Account");
		loginToAVendorAccount.clicksOnLogin();
		loginToAVendorAccount.selectTheRoleAs("Program Manager");
		userNavigationSteps.clickTacticsTab();
		userNavigationSteps.clickEmailSubTab();
		createNonTemplateEmail.clickOnCreateNewEmail();
		createNonTemplateEmail.clickCreateNewContent();
		createNonTemplateEmail.enterEmailName(emailName);
		createNonTemplateEmail.enterEmailDescription("This is a email to test");
		createNonTemplateEmail.clickSaveEmailNameAndDescription();
		createNonTemplateEmail.enterTemplateSubjectLine("This is a subject line for Email Tactics");
		createTemplateEmail.clickSaveEmailTemplate();
		downloadAndVerify.clickEmailDownloadButtonToChooseDownloadType();
		downloadAndVerify.clickDownloadHTML();
		downloadAndVerify.clickEmailDownloadButtonToChooseDownloadType();
		downloadAndVerify.clickDownloadOFT();
		
		//Then
		if(genericFunctions.getOperaingSystem().equals(OperatingSystem.OS_WINDOWS))
		{
			downloadAndVerify.shouldBeAbleToSeeSameContentInBothHtmlAndOft(expectedEmailName,genericFunctions.getDownloadPath());
		}
		else if (genericFunctions.getOperaingSystem().equals(OperatingSystem.OS_MAC_OS))
		{
			downloadAndVerify.shouldBeAbleToDownloadAsHtmlWithFileNameAtPath(expectedEmailName,genericFunctions.getDownloadPath());
			downloadAndVerify.shouldBeAbleToDownloadAsOftWithFileNameAtPath(expectedEmailName,genericFunctions.getDownloadPath());
		}
	}
}
