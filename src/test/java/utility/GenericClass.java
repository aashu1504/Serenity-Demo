package utility;

import java.io.File;
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

	/* Get the latest file from a specific directory*/
	public File getLatestFilefromDir(String downloadPath) {
		 File dir = new File(downloadPath);
		    File[] files = dir.listFiles();
		    if (files == null || files.length == 0) {
		        return null;
		    }
		
		    File lastModifiedFile = files[0];
		    for (int i = 1; i < files.length; i++) {
		       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
		           lastModifiedFile = files[i];
		       }
		    }
		    return lastModifiedFile;	}
	

}
