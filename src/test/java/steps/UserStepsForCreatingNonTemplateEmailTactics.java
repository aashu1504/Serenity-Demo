package steps;

import net.thucydides.core.annotations.Step;
import ui.EmailPage;

public class UserStepsForCreatingNonTemplateEmailTactics {

	EmailPage emailPage;

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
}
