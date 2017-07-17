package features.EmailDownload;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import steps.UserStepsForEmailDownload;

@RunWith(SerenityRunner.class)  //Do not name the java file with continuous capital letters as it will shown duplicate stories in report.
public class HtmlAndOftDownloadForEmails {
	
	@Steps
	UserStepsForEmailDownload structuredWebUser;
	
	@Managed
    WebDriver driver;
	
	@Test
	public void shouldBeAbleToDownloadHtmlAndOftFileFromProgramManager() throws InterruptedException
	{
		//Given
		structuredWebUser.isOnStructuredWebHomePage();
		
		//When
		structuredWebUser.entersSiteID("48482");
		structuredWebUser.clicksOnLogin();
		structuredWebUser.switchToSecondWindow();
		structuredWebUser.selectTheRoleAs("Program Manager");

		
		
		//Then
		structuredWebUser.shouldSeePageTitleContaining("StructuredWeb QA");
	}
}