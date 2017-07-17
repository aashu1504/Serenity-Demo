package steps;

import static org.assertj.core.api.Assertions.assertThat;

import net.thucydides.core.annotations.Step;
import ui.CurrentPage;
import ui.StructuredWebHomePage;
import utility.GenericClass;

public class UserStepsForEmailDownload {

	CurrentPage currentPage;
	StructuredWebHomePage structuredWebHomePage;
	CustomerServicePage customerServicePage;
	AdminLoginPage adminLoginPage;
	GenericClass genericFunctions;
	
	@Step
	public void isOnStructuredWebHomePage() {
		structuredWebHomePage.open();
	}

	@Step
	public void entersSiteID(String siteID) {
		customerServicePage.entersSiteID(siteID);
	}
	
	@Step
	public void clicksOnLogin() throws InterruptedException {
		customerServicePage.clickLogin();
	}

	@Step
	public void switchToSecondWindow() {
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
}
