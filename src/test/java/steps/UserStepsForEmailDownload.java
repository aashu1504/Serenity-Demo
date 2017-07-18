package steps;

import static org.assertj.core.api.Assertions.assertThat;

import net.thucydides.core.annotations.Step;
import ui.AdminLoginPage;
import ui.CurrentPage;
import ui.CustomerServicePage;
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

	@Step
	public void isOnStructuredWebHomePage() {
		structuredWebHomePage.open();
		genericFunctions.maximizeBrowserWindow();
	}

	@Step
	public void entersSiteID(String siteID) {
		customerServicePage.entersSiteID(siteID);
	}

	@Step
	public void clicksOnLogin() {
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
}
