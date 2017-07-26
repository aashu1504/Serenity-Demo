package utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	public File getLatestFilefromDir(String downloadPath){
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

	/* Get the list of files from a specific directory and compare with expected file name - We will not use this as downloaded file name is same for all downloads. Even match is done for old file, this will pass*/
	public boolean isHTMLFileDownloaded(String downloadPath, String expectedFileName) {
		boolean flag = false;
	    File dir = new File(downloadPath);
	    File[] dir_contents = dir.listFiles();
	  	    
	    for (int i = 0; i < dir_contents.length; i++) {
	        if (dir_contents[i].getName().contains(expectedFileName) & dir_contents[i].getName().contains(".htm"))
	            return flag=true;
	            }

	    return flag;
	}
	
	public boolean isOFTFileDownloaded(String downloadPath, String expectedFileName) {
		boolean flag = false;
	    File dir = new File(downloadPath);
	    File[] dir_contents = dir.listFiles();
	  	    
	    for (int i = 0; i < dir_contents.length; i++) {
	        if (dir_contents[i].getName().contains(expectedFileName) & dir_contents[i].getName().contains(".oft"))
	            return flag=true;
	            }

	    return flag;
	}
	
	public String getCurrentDateTime()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
		return dateFormat.format(date);
	}
	

}
