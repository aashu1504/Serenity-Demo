package testpackage;

import static org.assertj.core.api.Assertions.assertThat;

import net.thucydides.core.annotations.Step;
import ui.CurrentPage;

public class NavigatingUser {

	EbayHomePage ebayHomePage;
	CurrentPage currentPage;
	CategoryNavigationBar categoryNavigationBar;
	
	@Step
	public void isOnHomePage() {
		// TODO Auto-generated method stub
		ebayHomePage.open();
	}

	@Step
	public void shouldSeePageTitleContaining(String expectedTitle) {
		// TODO Auto-generated method stub
		assertThat(currentPage.getTitle()).containsIgnoringCase(expectedTitle);
	}
	
	@Step
	public void NavigatesToCategory(Category category) {
		// TODO Auto-generated method stub
		categoryNavigationBar.selectCategory(category);
	}

}
