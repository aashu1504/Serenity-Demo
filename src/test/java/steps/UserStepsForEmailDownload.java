package steps;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;

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

	@Step
	public void shouldBeAbleToDownloadAsHtmlWithFileName(String expectedFileName) {
		 String downloadPath ="/Users/ashishu/Downloads";
		 File getLatestDownloadedFile = genericFunctions.getLatestFilefromDir(downloadPath);
		 String actualFileName = getLatestDownloadedFile.getName();
		 Assert.assertTrue(actualFileName.contains(expectedFileName));
	}
}
