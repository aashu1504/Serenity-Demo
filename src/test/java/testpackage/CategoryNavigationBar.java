package testpackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;

public class CategoryNavigationBar extends PageObject{

	@FindBy(xpath = ".//*[@id='w0-container']/li[4]/a")
    WebElement motorsOption;
	
	@FindBy(xpath = ".//*[@id='w0-container']/li[6]/a")
	WebElement electronicsOption;
	
	
	public void selectCategory(Category category) {		
		if(electronicsOption.getText().equalsIgnoreCase(category.toString()))
		{
			electronicsOption.click();
		}
		else if(motorsOption.getText().equalsIgnoreCase(category.toString()))
		{
			motorsOption.click();
		}
	}

	
}
