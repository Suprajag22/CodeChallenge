package herokuapp;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.*;

public class VerifyTitle {
	WebDriver driver;

	@Test(priority=1)
	public void launchApp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/challenging_dom");
	}
	
	@Test(priority=2)
	public void maximizeApp()
	{
		driver.manage().window().maximize();
	}
	
	
	@Test(priority=3)
	public void verifyTitle()
	{
		//JavascriptExecutor interface object by Type casting		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String strTitleName = js.executeScript("return document.title;").toString();
		String strExpected = "The Internet";
		assert strTitleName.equals(strExpected);
		Reporter.log("Page Title is: "+strTitleName,true);
	}
	
	@Test(priority=4)
	public void closeBrowser()
	{
		driver.close();
	}

}
