package features.EmailTemplateDownload;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import steps.UserStepsForEmailDownload;

@RunWith(SerenityRunner.class)  //Do not name the java file with continuous capital letters as it will shown duplicate stories in report.
public class EmailTemplateDownloadAsHtmlAndOft {
	
	@Steps
	UserStepsForEmailDownload structuredWebUser;	
	
	@Managed
    WebDriver driver;
	
	@Test
	public void shouldBeAbleToDownloadHtmlAndOftFileFromContentManager()
	{
		//Given
		structuredWebUser.isOnStructuredWebHomePage();
		
		
		//When
		structuredWebUser.entersSiteID("48482");
		structuredWebUser.clicksOnLogin();
		structuredWebUser.selectTheRoleAs("Content Manager");
		structuredWebUser.clickOnTemplatesTab();
		structuredWebUser.clickEmailSubTab();
		structuredWebUser.clickNewEmailTemplate();
		structuredWebUser.enterEmailTemplateName("Email Template To Test");
		structuredWebUser.enterEmailTemplateDescription("This is a template email to test");
		structuredWebUser.clickSaveEmailTemplate();
		structuredWebUser.enterEmailTemplateContent("This is the content to be written in editor");
		structuredWebUser.clickSaveEmailTemplate();
		structuredWebUser.clickTacticsTab();
		structuredWebUser.clickEmailSubTab();
		
		//Then
		//structuredWebUser.shouldSeePageTitleContaining("StructuredWeb QA");
	}
}