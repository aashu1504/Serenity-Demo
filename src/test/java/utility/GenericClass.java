package utility;

import java.util.Iterator;
import java.util.Set;

import net.serenitybdd.core.pages.PageObject;

public class GenericClass extends PageObject{
	
	String firstWindow = null;
	String secondWindow = null;
	
	public void switchToSecondWindow() {
		
		System.out.println("In Window Handle");
		Set<String> windows = getDriver().getWindowHandles();
		System.out.println("In Window Handle Line 1");
		Iterator<String> window = windows.iterator();
		firstWindow = window.next();
		secondWindow = window.next();		
		getDriver().switchTo().window(secondWindow);		
	}

	
	public void maximizeBrowserWindow() {
		getDriver().manage().window().maximize();		
	}

}
