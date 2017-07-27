package utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import net.serenitybdd.core.pages.PageObject;

public class GenericClass extends PageObject{
	
	String firstWindow = null;
	String secondWindow = null;
	public static final String UTF8_BOM = "\uFEFF";
	
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


	public String getFilePath(String expectedFileName, String downloadPath, String downloadedFileType) {
		String pathOfDownloadedFile = null;
	    File dir = new File(downloadPath);
	    File[] dir_contents = dir.listFiles();
	  	    
	    for (int i = 0; i < dir_contents.length; i++) 
	    {
	        if (dir_contents[i].getName().contains(expectedFileName) & dir_contents[i].getName().contains(downloadedFileType))
	        {
	        	pathOfDownloadedFile = dir_contents[i].getPath();
	        }
	    }
		return pathOfDownloadedFile;
}


	public String convertOftFileToHtmlAndGetItsPath(String getOFTFilePath) {
		return null;
	}
	
	public boolean compareOftFileWithHtmlFile(String getHTMLFilePath, String getOftToHtmlGeneratedFilePath) throws IOException {
		 	File file1 = new File(getHTMLFilePath);
		    File file2 = new File(getOftToHtmlGeneratedFilePath);
		    BufferedReader br1 = new BufferedReader(new InputStreamReader(new FileInputStream(file1), "UTF-8"));
		    BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(file2), "UTF-8"));
		    String thisLine = null;
		    String thatLine = null;
		    StringBuilder builder = new StringBuilder();
		    StringBuilder builder1 = new StringBuilder();
		    while ((thisLine = br1.readLine()) != null) {
		    	String sanitizedString = removeUTF8BOM(thisLine).replace("\t", "");  //remove tabs which come between the tags AND remove UTF8BOM encoding from HTML File 
		    	builder.append(sanitizedString);
		    }
		    while ((thatLine = br2.readLine()) != null) {
		    	String sanitizedString = removeUTF8BOM(thatLine).replace("\t", "");
		        builder1.append(sanitizedString);
		    }
		    br1.close();
		    br2.close();
	        return builder.toString().equalsIgnoreCase(builder1.toString());
		}
	
	// Remove UTF8BOM encoding from HTML File
	private static String removeUTF8BOM(String s) {
	    if (s.startsWith(UTF8_BOM)) {
	        s = s.substring(1);
	    }
	    return s;
	}
}
