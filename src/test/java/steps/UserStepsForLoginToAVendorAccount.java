package steps;

import static org.assertj.core.api.Assertions.assertThat;

import net.thucydides.core.annotations.Step;
import ui.AdminLoginPage;
import ui.CurrentPage;
import ui.CustomerServicePage;
import ui.StructuredWebHomePage;
import utility.GenericClass;

public class UserStepsForLoginToAVendorAccount {
	
	CurrentPage currentPage;
	StructuredWebHomePage structuredWebHomePage;
	CustomerServicePage customerServicePage;
	AdminLoginPage adminLoginPage;
	GenericClass genericFunctions;
	
		@Step
		public void isOnStructuredWebHomePage() {
			structuredWebHomePage.open();
			genericFunctions.maximizeBrowserWindow();
		}
	
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

}
