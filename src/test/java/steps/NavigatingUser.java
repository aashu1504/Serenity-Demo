package steps;

import static org.assertj.core.api.Assertions.assertThat;
import model.Category;
import net.thucydides.core.annotations.Step;
import ui.CategoryNavigationBar;
import ui.CurrentPage;
import ui.EbayHomePage;

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
