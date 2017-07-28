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

import com.google.common.base.Strings;

import model.OperatingSystem;
import net.serenitybdd.core.pages.PageObject;

public class GenericClass extends PageObject{
	
	public static String firstWindow = null;
	public static String secondWindow = null;
	public static final String UTF8_BOM = "\uFEFF";	
	private static OperatingSystem os = null;
	public static String operatingSystem;
	public static String downloadPath;
	
	
	// Get the operating System
    public OperatingSystem getOperaingSystem() {
        if (os == null) {
        	operatingSystem = System.getProperty("os.name").toLowerCase();
        	if(operatingSystem.contains("nix") || operatingSystem.contains("nux") || operatingSystem.contains("aix"))
        	{
        		os = OperatingSystem.OS_LINUX;
        	}
        	else if(operatingSystem.contains("windows")) 
        	{
        		os = OperatingSystem.OS_WINDOWS;
        	}
        	else if(operatingSystem.contains("solaris") || operatingSystem.contains("sunos")) 
        	{
        		os = OperatingSystem.OS_SOLARIS;	
        	}
        	else if(operatingSystem.contains("mac os") || operatingSystem.contains("macos") || operatingSystem.contains("darwin"))
        	{
        		os = OperatingSystem.OS_MAC_OS;
        	}
    }
        return os;
}
	
    //Get the download Location based on different Operating Systems
    public String getDownloadPath()
    {
    	if(getOperaingSystem().equals(OperatingSystem.OS_MAC_OS))
		{
			downloadPath = "/Users/ashishu/Downloads/";
		}
		else if(getOperaingSystem().equals(OperatingSystem.OS_WINDOWS))
		{
			downloadPath = "C:\\Users\\ashishu\\Downloads\\";
		}
    	return downloadPath;
    }
	
	// Switch to Second Window : Window Handling
	public void switchToSecondWindow() {
		Set<String> windows = getDriver().getWindowHandles();
		Iterator<String> window = windows.iterator();
		firstWindow = window.next();
		secondWindow = window.next();		
		getDriver().switchTo().window(secondWindow);		
	}
	
	// Maximize Browser Window
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
	public boolean isHTMLFileGenerated(String downloadPath, String expectedFileName) {
		boolean flag = false;
	    File dir = new File(downloadPath);
	    File[] dir_contents = dir.listFiles();
	  	    
	    for (int i = 0; i < dir_contents.length; i++) {
	        if (dir_contents[i].getName().contains(expectedFileName) & dir_contents[i].getName().contains(".htm"))
	            return flag=true;
	            }

	    return flag;
	}
	
	//Check if a File with a given File Name is downloaded in downloads folder and is of type .OFT
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
	
	//get current date and time in format : 2016/11/16 12:08:43 (yyyy/MM/dd HH:mm:ss)
	public String getCurrentDateTime()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); 
		return dateFormat.format(date);
	}

	//get Full path of the File like : "/users/ashish/Downloads/DemoFile.html"
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
	
	//Convert OFT File To HTML File via Batch File and OFT To HTML Converter
	public String convertOftFileToHtmlAndGetItsPath(String FullOFTFilePath) throws IOException, InterruptedException {
		String OftToHtmConvertedFullFilePath = null;
		if(!Strings.isNullOrEmpty(FullOFTFilePath))
		{
			String OftToHtmlConvertedFileName = "OftToHtml_" + getCurrentDateTime().replaceAll("[ /:]+", "_") + ".htm";
			OftToHtmConvertedFullFilePath = getDownloadPath() + OftToHtmlConvertedFileName;
			Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "start OftToHtmlConverter.bat", FullOFTFilePath, OftToHtmConvertedFullFilePath});
			Thread.sleep(10000L);
			if(isHTMLFileGenerated(getDownloadPath(), OftToHtmlConvertedFileName))
			{
				return OftToHtmConvertedFullFilePath;
			}
			else
			{
				return null;
			}
		}
		else
		{
			return OftToHtmConvertedFullFilePath;
		}
	}
	
	//compare OFT with HTML File - Convert OFT To HTML First using above function, then compare both HTML's
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
