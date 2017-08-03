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
	
	@Step
	public void clickOnCreateNewEmail() {
		emailPage.clickCreateNewEmailButton();
	}

	@Step
	public void clickCreateNewContent() {
		emailPage.clickCreateNewContent();
	}
	
	@Step
	public void enterEmailName(String emailName) {
		emailPage.enterEmailName(emailName);
	}
	
	@Step
	public void enterEmailDescription(String emailDescription) {
		emailPage.enterEmailDescription(emailDescription);;
	}
	
	@Step
	public void clickSaveEmailNameAndDescription() {
		emailPage.clickSaveEmailNameAndDescription();
	}
}
