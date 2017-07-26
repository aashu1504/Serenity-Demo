package features.EmailTemplateDownload;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Steps;
import steps.UserStepsForEmailDownload;

@Narrative(text={"In order to send a Template Email with pre filled content",                      
        "As a Program Manager",
        "I want to download my Email Templates in OFT and HTML Format"})

@RunWith(SerenityRunner.class)  
public class EmailTemplateDownloadByProgramManagerScope {

	@Steps
	UserStepsForEmailDownload structuredWebUser;	
	
	@Managed
    WebDriver driver;
	
	String downloadPath = "/Users/ashishu/Downloads";
	
	@Test
	@Issue("SW-6386")
	public void shouldBeAbleToDownloadEmailTemplateAsHtmlFromContentManager() throws InterruptedException
	{
	}
}
