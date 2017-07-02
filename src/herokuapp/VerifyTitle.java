package herokuapp;

import junit.framework.Assert;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


@SuppressWarnings("deprecation")
public class VerifyTitle {
	WebDriver driver;

	@Test(priority=1)
	public void launchApp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/challenging_dom");
		driver.manage().window().maximize();
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
		Assert.assertEquals(strExpected, strTitleName);
	}
	
	@Test(priority=4)
	public void closeBrowser()
	{
		driver.close();
	}

}
