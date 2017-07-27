package testpackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CompareFilesCopy{

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
	    
	    
	    BufferedReader br1 = new BufferedReader(
	            new InputStreamReader(new FileInputStream(file1), "UTF-8"));
	    BufferedReader br2 = new BufferedReader(
	            new InputStreamReader(new FileInputStream(file2), "UTF-8"));

	    String thisLine = null;
	    String thatLine = null;

	    List<String> list1 = new ArrayList<String>();
	    List<String> list2 = new ArrayList<String>();
	    StringBuilder builder = new StringBuilder();
	    StringBuilder builder1 = new StringBuilder();
	    
	    while ((thisLine = br1.readLine()) != null) {
	    	String sanitizedString = removeUTF8BOM(thisLine).replace("\t", "");
	    	builder.append(sanitizedString);
//	    	System.out.println(sanitizedString);
//	    	System.out.println((int)sanitizedString.charAt(0));
	        //list1.add(thisLine);
	    }
	    while ((thatLine = br2.readLine()) != null) {
	        String sanitizedString = removeUTF8BOM(thatLine).replace("\t", "");
	        builder1.append(sanitizedString);
	    }

	    br1.close();
	    br2.close();
	    String a= builder.toString().replace("\\s+|\\s+", "");
	    String b= builder1.toString().replace("\\s+|\\s+", "");
	    //builder.toString().equalsIgnoreCase(builder1.toString());
         //boolean a = list1.equals(list2);
         System.out.println(a.equalsIgnoreCase(b));
         
         System.out.println(builder);
         System.out.println("=========================");
         System.out.println(builder1);
         
         //fromInternet();
         //name();
	}
	
	public static void fromInternet() throws IOException {
		BufferedReader reader1 = new BufferedReader(new FileReader("/Users/ashishu/Downloads/HTML.htm"));
        
        BufferedReader reader2 = new BufferedReader(new FileReader("/Users/ashishu/Downloads/OFT.htm"));
         
        String line1 = reader1.readLine();
         
        String line2 = reader2.readLine();
         
        boolean areEqual = true;
         
        int lineNum = 1;
        
        char[] c1 = new char[1];
        char[] c2 = new char[1];
        
        reader1.read(c1);
        reader2.read(c2);
         
//        while (line1 != null || line2 != null)
//        {
////            if(line1 == null || line2 == null)
////            {
////                areEqual = false;
////                 
////                break;
////            }
////            else if(! line1.equalsIgnoreCase(line2))
////            {
////                areEqual = false;
////                 
////                break;
////            }
////             
////            line1 = reader1.readLine();
////             
////            line2 = reader2.readLine();
//        	
//        	
//             
//            lineNum++;
//        }
//         
//        if(areEqual)
//        {
//            System.out.println("Two files have same content.");
//        }
//        else
//        {
//            System.out.println("Two files have different content. They differ at line "+lineNum);
//             
//            System.out.println("File1 has "+line1+" and File2 has "+line2+" at line "+lineNum);
//        }
        
        while (c1 != null || c2 != null)
        {
        	System.out.println(c1[0]);
        	System.out.println(c2[0]);
            if(c1 == null || c2 == null)
            {
                areEqual = false;
                 
                break;
            }
            else if(!(c1[0] == c2[0] ))
            {
                areEqual = false;
                 
                break;
            }
             
            reader1.read(c1);
             
            reader2.read(c2);
        	
        	
             
            lineNum++;
        }
         
        if(areEqual)
        {
            System.out.println("Two files have same content.");
        }
        else
        {
            System.out.println("Two files have different content. They differ at line "+lineNum);
             
            System.out.println("File1 has "+c1[0]+" and File2 has "+c2[0]+" at line "+lineNum);
        }
         
        reader1.close();
         
        reader2.close();
	}
	
	 public static void name() throws IOException {
		 FileReader inputStream = null, inputStream1 = null;
	        

	        try {
	            inputStream = new FileReader("/Users/ashishu/Downloads/HTML.htm");
	            inputStream1 = new FileReader("/Users/ashishu/Downloads/OFT.htm");

	            int c, c1;
	            while ((c = inputStream.read()) != -1) {
	            	c1 = inputStream1.read();
	            	if (c != c1) {
	            		System.out.println("Not same: " + c + " " + c1);
	            		System.out.println((char)c);
	            	} else {
	            		System.out.println("Same" + c + " " + c1);
	            	}
	            }
	        } finally {
	            if (inputStream != null) {
	                inputStream.close();
	            }
	            if (inputStream1 != null) {
	                inputStream1.close();
	            }
	        }
	}

}
