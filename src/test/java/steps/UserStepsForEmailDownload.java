package steps;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.assertj.core.util.Strings;
import org.junit.Assert;

import net.thucydides.core.annotations.Step;
import ui.AdminLoginPage;
import ui.CurrentPage;
import ui.CustomerServicePage;
import ui.EmailPage;
import ui.EmailTemplatePage;
import ui.NavigationBar;
import ui.StructuredWebHomePage;
import utility.GenericClass;

public class UserStepsForEmailDownload {

	CurrentPage currentPage;
	StructuredWebHomePage structuredWebHomePage;
	CustomerServicePage customerServicePage;
	AdminLoginPage adminLoginPage;
	GenericClass genericFunctions;
	NavigationBar navigationBar;
	EmailTemplatePage emailTemplatePage;
	EmailPage emailPage;

	@Step
	public void isOnStructuredWebHomePage() {
		structuredWebHomePage.open();
		genericFunctions.maximizeBrowserWindow();
	}

	// Storing data between steps
	@Step("SITE Id entered is {0} is for a {1} vendor")
	public void entersSiteID(String siteID, String vendor) {
		customerServicePage.entersSiteID(siteID);
	}

	@Step
	public void clicksOnLogin() {
		//----------------------------------------------------------//
		// This is to call a step in a step, So here session comes into picture. 
		// Here : http://thucydides.info/docs/serenity-staging/#_storing_data_between_steps
		//Store value in the called step at the beginning in a variable and use it later while calling.
		//entersSiteID(null, null);
		//----------------------------------------------------------//
		customerServicePage.clickLogin();
		genericFunctions.switchToSecondWindow();
	}

	@Step
	public void selectTheRoleAs(String roleType) {
		adminLoginPage.selectTheRole(roleType);
	}

	@Step
	public void shouldSeePageTitleContaining(String expectedTitle) {
		assertThat(currentPage.getTitle()).containsIgnoringCase(expectedTitle);
	}

	@Step
	public void clickOnTemplatesTab() {
		navigationBar.clickTemplateTab();
	}

	@Step
	public void clickEmailSubTab() {
		navigationBar.clickEmailSubTab();
	}

	@Step
	public void clickNewEmailTemplate() {
		emailTemplatePage.clickNewEmailTemplate();
	}

	@Step
	public void enterEmailTemplateName(String emailTemplateName) {
		emailTemplatePage.enterEmailTemplateName(emailTemplateName);
	}

	@Step
	public void enterEmailTemplateDescription(String emailDescription) {
		emailTemplatePage.enterEmailTemplateDescription(emailDescription);
	}

	@Step
	public void clickSaveEmailTemplate() {
		emailTemplatePage.clickSaveEmailTemplate();
	}

	@Step
	public void enterEmailTemplateContent(String emailTemplateContent) {
		emailTemplatePage.enterEmailTemplateContent(emailTemplateContent);
	}

	@Step
	public void clickTacticsTab() {
		navigationBar.clickTacticsTab();
	}
	
	@Step
	public void clickNewlyCreatedEmailTemplate(String templateEmailName) {
		emailPage.clickNewlyCreatedTemplate(templateEmailName);		
	}

	@Step
	public void enterTemplateSubjectLine(String subjectLine) {
		emailPage.enterTemplateSubject(subjectLine);	
	}

	@Step
	public void clickOnSaveAndRefreshPreview() {
		emailPage.saveAndRefreshClick();
	}

	@Step
	public void clickDownloadHTML() {
		emailPage.clickDownloadHTMLButton();
	}
	
	@Step
	public void clickDownloadOFT() {
		emailPage.clickDownloadOFTButton();
	}
	
	// Check if HTMl File is Downloaded in the Downloads Folder
	@Step
	public void shouldBeAbleToDownloadAsHtmlWithFileNameAtPath(String expectedHtmlFileName, String downloadPath) {
		boolean isHTMLFileDownloaded =  genericFunctions.isHTMLFileGenerated(downloadPath, expectedHtmlFileName);
			 Assert.assertTrue(isHTMLFileDownloaded);
	}

	// Check if OFT File is Downloaded in the Downloads Folder
	@Step
	public void shouldBeAbleToDownloadAsOftWithFileNameAtPath(String expectedOftFileName, String downloadPath) {
		boolean isOFTFileDownloaded =  genericFunctions.isOFTFileDownloaded(downloadPath, expectedOftFileName);
			 Assert.assertTrue(isOFTFileDownloaded);
	}

	// Verify if content in the downloaded HTML and OFT File is Same
	@Step
	public void shouldBeAbleToSeeSameContentInBothHtmlAndOft(String expectedFileName, String downloadPath) throws IOException, InterruptedException {
		String getFullHTMLFilePath = genericFunctions.getFilePath(expectedFileName,downloadPath,".htm");
		String getFullOFTFilePath = genericFunctions.getFilePath(expectedFileName,downloadPath,".oft");
		String getOftToHtmlFullGeneratedFilePath = genericFunctions.convertOftFileToHtmlAndGetItsPath(getFullOFTFilePath);
		if(!Strings.isNullOrEmpty(getOftToHtmlFullGeneratedFilePath))
		{
			boolean isFileContentSame = genericFunctions.compareOftFileWithHtmlFile(getFullHTMLFilePath,getOftToHtmlFullGeneratedFilePath);
			Assert.assertTrue(isFileContentSame);
		}
		else
		{
			System.out.println("Issue while converting File from OFT to HTML");
			Assert.assertTrue(false);
		}
	}
}
