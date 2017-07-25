package testpackage;

public class test {

	static String actualFilePath  = "/Users/ashishu/Downloads/1.csv";
	static String  expectedFilePath = "/Users/ashishu/Downloads/2.csv";
	
	public static void main(String[] args) {
		    MD5EncoderUtilityy md5EncoderUtil = new MD5EncoderUtilityy();
		        if ((md5EncoderUtil.encodeToMd5(actualFilePath)).equals(md5EncoderUtil.encodeToMd5(expectedFilePath))) {
		            System.out.println("The files are same");
		        } else {
		            System.out.println("The files are NOT same");
		        }
		}
}
