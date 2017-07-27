package testpackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class CompareFiles{

	public static final String UTF8_BOM = "\uFEFF";
	
	private static String removeUTF8BOM(String s) {
	    if (s.startsWith(UTF8_BOM)) {
	        s = s.substring(1);
	    }
	    return s;
	}
	
	public static void main(String[] args) throws IOException {

	    File file1 = new File("/Users/ashishu/Downloads/HTML1.htm");
	    File file2 = new File("/Users/ashishu/Downloads/OFT1.htm");
	    BufferedReader br1 = new BufferedReader(new InputStreamReader(new FileInputStream(file1), "UTF-8"));
	    BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(file2), "UTF-8"));
	    String thisLine = null;
	    String thatLine = null;
	    StringBuilder builder = new StringBuilder();
	    StringBuilder builder1 = new StringBuilder();
	    while ((thisLine = br1.readLine()) != null) {
	    	String sanitizedString = removeUTF8BOM(thisLine).replace("\t", "");
	    	builder.append(sanitizedString);
	    	//System.out.println((int)sanitizedString.charAt(0));
	    }
	    while ((thatLine = br2.readLine()) != null) {
	    	String sanitizedString = removeUTF8BOM(thatLine).replace("\t", "");
	        builder1.append(sanitizedString);
	    }
	    br1.close();
	    br2.close();
         System.out.println(builder.toString().equalsIgnoreCase(builder1.toString()));
	}

}
