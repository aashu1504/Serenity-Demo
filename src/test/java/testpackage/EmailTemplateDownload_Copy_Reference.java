package testpackage;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Steps;
import steps.UserStepsForEmailDownload;
import utility.GenericClass;

//You can provide extra information about stories and requirements in several ways. 
//One is to use the @Narrative annotation in the test case, as shown here:
@Narrative(text={"In order to send a Template Email with pre filled content",                      
        "As a Content Manager",
        "I want to download my Email Templates in OFT and HTML Format"})
//Do not name the java file with continuous capital letters as it will shown duplicate stories in report. (This is default and has to be used)
@RunWith(SerenityRunner.class)  

//@RunWith(SerenityParameterizedRunner.class) // This is used for getting data from csv file
//@UseTestDataFrom(value="Data.csv")  // This is the csv file from where you want data.
//@Concurrent // Use this only if you have multiple data to read from csv file, The test will run in parallel with different data set
// @FixMethodOrder(MethodSorters.NAME_ASCENDING) To run junit test case in order of name of method in a class

public class EmailTemplateDownload_Copy_Reference {
	
	//private String siteId; // This is used only when you are fetching data from csv
    //private String role;   // This is used only when you are fetching data from csv

    // This is used only when you are fetching data from csv
//    public void setSITEID(String siteId) {
//        this.siteId = siteId;
//    }

    // This is used only when you are fetching data from csv
//    public void role(String role) {
//        this.role = role;
//    }

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
		structuredWebUser.shouldBeAbleToSeeSameContentInBothHtmlAndOft(expectedTemplateEmailName,genericFunctions.getDownloadPath());
	}
}