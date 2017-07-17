package utility;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Managed;

public class GenericClass extends PageObject{

	@Managed
    WebDriver driver;
	
	public void switchToSecondWindow() {
		System.out.println("In Window Handle");
		Set<String> windows = driver.getWindowHandles();
		System.out.println("In Window Handle Line 1");
		Iterator<String> window = windows.iterator();
		String firstWindow = window.next();
		String secondWindow = window.next();
		driver.switchTo().window(secondWindow);		
	}

}
