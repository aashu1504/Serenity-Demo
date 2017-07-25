package testpackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CompareFiles {

	public static void main(String[] args) throws IOException {

	    File file1 = new File("/Users/ashishu/Downloads/1.htm");
	    File file2 = new File("/Users/ashishu/Downloads/1.oft");

	    BufferedReader br1 = new BufferedReader(new FileReader(file1));
	    BufferedReader br2 = new BufferedReader(new FileReader(file2));

	    String thisLine = null;
	    String thatLine = null;

	    List<String> list1 = new ArrayList<String>();
	    List<String> list2 = new ArrayList<String>();

	    while ((thisLine = br1.readLine()) != null) {
	        list1.add(thisLine);
	    }
	    while ((thatLine = br2.readLine()) != null) {
	        list2.add(thatLine);
	    }

	    br1.close();
	    br2.close();

         boolean a = list1.equals(list2);
         System.out.println(a);
	}

}
