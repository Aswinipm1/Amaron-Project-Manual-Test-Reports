package amarontests;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import amaronbase.AmaronURLChrome;
import amaronpagelocate.AmaronLocateActions;

/* 
 * TEST ENVIRONMENT
 * 1st step : Project type	   --> Maven
 * 2nd step : Design pattern   --> POM
 * 3rd step : Language         --> Java
 * 4th step : IDE 			   --> Eclipse Committers 4.32.0
 * 5th step : Testing tool	   --> TestNG 7.10.2
 * 6th step : Framework        --> Data Driven
 * 7th step : Reporting Tool   --> Extent Reports 5.0.9
 */
	
public class AmaronTestRun extends AmaronURLChrome
{
	AmaronLocateActions alaobject;
	
	@BeforeMethod
	public void createObject() {
		alaobject=new AmaronLocateActions(driver);
		test = reports.createTest("Amaron Tests");
	}
	
	@Test(priority=1)
	public void verifyAmaronTitle() throws Exception 
	{
		alaobject.verifyAmaronTitle();
		logTestResult("Title verification");
	}
	
	@Test(priority=2)
	public void verifyLogo() throws Exception 
	{
		alaobject.verifyLogo();
		logTestResult("Logo verification");
	}
	
	@Test(priority=3)
	public void verifyAllLinks() throws Exception 
	{
		alaobject.linkSearch();
		logTestResult("All links verification");
	}
	
	@Test(priority=4)
	public void homeButtonActions()
	{
		alaobject.homeButtonActions();
		logTestResult("Home page button action verification");
	}
	/*
	@Test(priority=5)
	public void homeAppStoreIcons()
	{
		alaobject.homeAppStoreIcons();
		logTestResult("Playstore & Appstore link verification");
	}
	*/
	@Test(priority=6)
	public void contactSendQueries() throws InterruptedException
	{
		alaobject.contactSendQueries("Vishnu S","8105028854","vishnuS20@gmail.com","8105028854","ABR-PR-APBTZ4L");
		logTestResult("Contact Menu Verification");
	}
	
	@Test(priority=7)
	public void downloadAmaronLogo()
	{
		alaobject.downloadAmaronLogo();
		logTestResult("Download Amaron Logo");
	}
	
	@Test(priority=8)
	public void dataDrivenTest() throws Exception 
	{
		alaobject.searchFromExcel();
		logTestResult("Data driven test");
	}
	
	@Test(priority=9)
	public void signupNewUser() throws Exception 
	{
		alaobject.signupNewUser("8105028854","123456","achuz@gmail.com","abc123");
		logTestResult("New user Signup");
	}
	
	@Test(priority=10)
	public void LoginUser() throws Exception 
	{
		alaobject.LoginUser("achuz@gmail.com","abc123");
		logTestResult("User Login");
	}
	
	@Test(priority=11)
	public void searchBattery() throws Exception 
	{
		alaobject.searchTwoWheelerBattery("two wheeler","670661");
		logTestResult("Search product");
	}
	
	
	@AfterMethod
	public void browserClose(ITestResult result) throws IOException 
	{
		if(result.getStatus()==ITestResult.FAILURE) 
		{
			test.log(Status.FAIL, "Test failed: " + result.getName());
            test.log(Status.FAIL, "Error: " + result.getThrowable());
			
			String Screenshotpath=screenshotMethod(driver,result.getName());
			test.addScreenCaptureFromPath(Screenshotpath);
		}
		else if(result.getStatus()==ITestResult.SKIP) 
		{
			test.log(Status.SKIP, "Test skipped: " + result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "Test passed: " + result.getName());
		}
	}
	
	private void logTestResult(String testName) {
        test = reports.createTest("Test Passed : " + testName);
    }
	
	public static String screenshotMethod(WebDriver driver,String screenShotName) throws IOException {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination="./Screenshot"+screenShotName+".jpg";
		
		FileHandler.copy(src, new File(destination));
		return destination;
	}
	
	@AfterTest
	public void executeReport() {
		reports.flush();
		//WHILE RUNNING CROSS BROWSER TESTING
		//driver.quit();
	}
}