package steps;

import java.io.IOException;

import org.assertj.core.util.Strings;
import org.junit.Assert;

import net.thucydides.core.annotations.Step;
import ui.CommonPageObjects;
import ui.EmailPage;
import ui.EmailTemplatePage;
import utility.GenericClass;

public class UserStepsForDownloadAndVerification {

	GenericClass genericFunctions;
	EmailPage emailPage;
	CommonPageObjects commonPage;
	EmailTemplatePage emailTemplatePage;

	@Step
	public void clickDownloadHTML() {
		commonPage.clickDownloadHTMLButton();
	}
	
	@Step
	public void clickDownloadOFT() {
		commonPage.clickDownloadOFTButton();
	}
	
	// Check if HTMl File is Downloaded in the Downloads Folder
	@Step
	public void shouldBeAbleToDownloadAsHtmlWithFileNameAtPath(String expectedHtmlFileName, String downloadPath) {
		boolean isHTMLFileDownloaded =  genericFunctions.isHTMLFileGenerated(downloadPath, expectedHtmlFileName);
			 Assert.assertTrue(isHTMLFileDownloaded);
	}

	// Check if OFT File is Downloaded in the Downloads Folder
	@Step
	public void shouldBeAbleToDownloadAsOftWithFileNameAtPath(String expectedOftFileName, String downloadPath) {
		boolean isOFTFileDownloaded =  genericFunctions.isOFTFileDownloaded(downloadPath, expectedOftFileName);
			 Assert.assertTrue(isOFTFileDownloaded);
	}

	// Verify if content in the downloaded HTML and OFT File is Same
	@Step
	public void shouldBeAbleToSeeSameContentInBothHtmlAndOft(String expectedFileName, String downloadPath) throws IOException, InterruptedException {
		String getFullHTMLFilePath = genericFunctions.getFilePath(expectedFileName,downloadPath,".htm");
		String getFullOFTFilePath = genericFunctions.getFilePath(expectedFileName,downloadPath,".oft");
		String getOftToHtmlFullGeneratedFilePath = genericFunctions.convertOftFileToHtmlAndGetItsPath(getFullOFTFilePath);
		if(!Strings.isNullOrEmpty(getOftToHtmlFullGeneratedFilePath))
		{
			boolean isFileContentSame = genericFunctions.compareOftFileWithHtmlFile(getFullHTMLFilePath,getOftToHtmlFullGeneratedFilePath);
			Assert.assertTrue(isFileContentSame);
		}
		else
		{
			System.out.println("Issue while converting File from OFT to HTML");
			Assert.assertTrue(false);
		}
	}

	@Step
	public void clickEmailDownloadButtonToChooseDownloadType() {
		emailPage.clickEmailDownloadButtonToChooseDownloadType();
	}
	
	@Step
	public void clickEmailTemplateDownloadButtonToChooseDownloadType() {
		emailTemplatePage.clickEmailTemplateDownloadButtonToChooseDownloadType();
	}
}
