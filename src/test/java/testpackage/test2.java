package testpackage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class test2 {
	  static String thisLine;
	  
	public static void main(String[] args) throws IOException {
File file1 = new File("/Users/ashishu/Downloads/1.htm");
File file2 = new File("/Users/ashishu/Downloads/1.oft");

boolean compare1and2 = FileUtils.contentEquals(file1, file2);

System.out.println("Are both file same? " + compare1and2);
	}
}

///		File file1 = new File("/Users/ashishu/Downloads/1.oft");
//		File file2 = new File("/Users/ashishu/Downloads/1.htm");
//		FileInputStream fin =  new FileInputStream(file1);
//		  BufferedReader myInput = new BufferedReader(new InputStreamReader(fin));
//		  StringBuilder sb = new StringBuilder();
//
//		while ((thisLine = myInput.readLine()) != null) {  
//		             sb.append(thisLine);
//		  }
//		
//		FileInputStream fin1 =  new FileInputStream(file1);
//		  BufferedReader myInput1 = new BufferedReader(new InputStreamReader(fin1));
//		  StringBuilder sb1 = new StringBuilder();
//
//		while ((thisLine = myInput1.readLine()) != null) {  
//		             sb1.append(thisLine);
//		  }
//		if(sb.equals(sb1))
//		{
//			System.out.println("same content");
//		}
//		else
//		{
//			System.out.println("diffrnt content");
//		}
//	}
