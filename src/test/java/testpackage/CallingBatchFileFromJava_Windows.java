package testpackage;

import java.io.IOException;

public class CallingBatchFileFromJava_Windows {

	public static void main(String[] args) throws IOException {
			String var1 = "OFTFile.oft";
			String var2 = "ashish.htm";
			    Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "start D:\\OftTest\\Independentsoft.Msg\\12.bat", var1, var2});
	}

}
