package amaronbase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class AmaronURLChrome {
	
	//CODE FOR CROSS BROWSER TESTING
	/*public static WebDriver driver;
	
	public static ExtentSparkReporter htmlReporter;
    public static ExtentReports reports;
    public static ExtentTest test;
	
	@Parameters("browser")
    @BeforeTest
    public void DriverUrlSetup(String browser) 
	{

        if (browser.equalsIgnoreCase("chrome")) 
        {
            driver = new ChromeDriver();
        } 
        else if (browser.equalsIgnoreCase("edge")) 
        {
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.get("https://www.amaron.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        
        htmlReporter = new ExtentSparkReporter("./Reports/AmaronReport.html");
		htmlReporter.config().setDocumentTitle("Amaron Automation Report");
        htmlReporter.config().setReportName("Amaron Functional Test");
        htmlReporter.config().setTheme(Theme.STANDARD);

        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);
        reports.setSystemInfo("Hostname", "Localhost");
        reports.setSystemInfo("OS", "Windows 11");
        reports.setSystemInfo("Browser Name", "Chrome");
        reports.setSystemInfo("Tester Name", "Aswini PM");
    }
	*/
	public static WebDriver driver;
	
	public static ExtentSparkReporter htmlReporter;
    public static ExtentReports reports;
    public static ExtentTest test;
	
	@BeforeTest
	public void DriverUrlSetup() 
	{
		//CONFIGURING HTML REPORTER
		htmlReporter = new ExtentSparkReporter("./Reports/AmaronReport.html");
		htmlReporter.config().setDocumentTitle("Amaron Automation Test Report");
        htmlReporter.config().setReportName("Amaron Functional Test");
        htmlReporter.config().setTheme(Theme.STANDARD);

        //CONFIGURING EXTENT REPORTS
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);
        reports.setSystemInfo("Hostname", "Localhost");
        reports.setSystemInfo("OS", "Windows 11");
        reports.setSystemInfo("Browser Name", "Chrome");
        reports.setSystemInfo("Tester Name", "Aswini PM");
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amaron.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
	}
}