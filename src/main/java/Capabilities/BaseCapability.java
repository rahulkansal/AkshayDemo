package Capabilities;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.FileUtility;


public class BaseCapability {
	public static ExtentReports extentReport;
	public static ExtentTest extentTest;
	public static File path;
	public static String subFolderPath = "";
	public static Logger log = Logger.getLogger(BaseCapability.class.getName());
	public WebDriver driver;
	
	public void generateReport()
	{
		DOMConfigurator.configure(System.getProperty("user.dir") + "\\src\\main\\resources\\log4j.xml" );
	
		subFolderPath =  System.getProperty("user.dir") + "/Reports/";
		
		path = FileUtility.CreateFolder(subFolderPath);
		String userName = System.getProperty("user.name");
        String timeStamp =  FileUtility.Timestamp();

        path = FileUtility.CreateFolder(subFolderPath);
        path =  FileUtility.CreateFolder(path.getAbsolutePath() + "/" + userName);
        path = FileUtility.CreateFolder(path.getAbsolutePath()+ "/" + timeStamp);
		
        extentReport = new ExtentReports(path.getAbsolutePath() + "\\ExtentReport.html");
        path = FileUtility.CreateFolder(path.getAbsolutePath()+"\\ScreenShots");
		extentReport.addSystemInfo("Environment", "SIT");
        extentReport.loadConfig(new File(System.getProperty("user.dir")+"\\src\\main\\resources\\extent-config.xml"));
        log.info("Extent Report has Started");
		
	}
	
	public void openBrowser(String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
		System.getProperty("webdriver.chrome.driver", "C:\\Akshay\\sportitude\\src\\main\\resources\\chromedriver.exe");	
	    driver = new ChromeDriver();
	    
		}
		else if(browserName.equalsIgnoreCase("edge")){
			System.getProperty("webdriver.chrome.driver", "C:\\Akshay\\sportitude\\src\\main\\resources\\msedgedriver.exe");		
		    driver = new EdgeBrowser();
		}
		driver.manage().window().maximize();
		driver.get("https://google.com");
		
		
	}
	
	@BeforeSuite
	public void beforeSuite() {
		generateReport();
		
	}
	
	@BeforeClass
	public void beforeClass() {
		openBrowser("edge");
	}
	
	@AfterSuite
	public void afterSuite()
	{
		extentReport.flush();
		driver.quit();
		
	}
	
}
