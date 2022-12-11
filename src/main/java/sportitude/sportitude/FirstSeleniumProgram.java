package sportitude.sportitude;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Capabilities.BaseCapability;

public class FirstSeleniumProgram extends BaseCapability{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstSeleniumProgram firstSeleniumProgram = new FirstSeleniumProgram();
		firstSeleniumProgram.generateReport();
		
		System.getProperty("webdriver.chrome.driver", "C:\\Akshay\\sportitude\\src\\main\\resources\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com");
		
		driver.manage().window().maximize();
				
	}

}
