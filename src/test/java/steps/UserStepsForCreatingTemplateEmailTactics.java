package steps;

import net.thucydides.core.annotations.Step;
import ui.EmailTemplatePage;

public class UserStepsForCreatingTemplateEmailTactics {

	EmailTemplatePage emailTemplatePage;

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
	public void enterEmailTemplateContent(String emailTemplateContent) {
		emailTemplatePage.enterEmailTemplateContent(emailTemplateContent);
	}
	
	@Step
	public void clickSaveEmailTemplate() {
		emailTemplatePage.clickSaveEmailTemplate();
	}
}
