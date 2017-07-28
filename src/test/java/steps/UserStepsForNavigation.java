package steps;

import net.thucydides.core.annotations.Step;
import ui.NavigationBar;

public class UserStepsForNavigation {

	NavigationBar navigationBar;
	
	@Step
	public void clickOnTemplatesTab() {
		navigationBar.clickTemplateTab();
	}

	@Step
	public void clickEmailSubTab() {
		navigationBar.clickEmailSubTab();
	}
	
	@Step
	public void clickTacticsTab() {
		navigationBar.clickTacticsTab();
	}
	
}
