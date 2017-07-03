package herokuapp;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.*;
@SuppressWarnings("deprecation")
public class VerifyHeader {
	WebDriver driver;
	String strAppURL,nodeURL;
	
	//Jenkins setup
	/*public void initSetup() throws MalformedURLException
	{
	strAppURL = "https://the-internet.herokuapp.com/challenging_dom";
	nodeURL = "http://192.168.0.3:5617/wd/hub";
	DesiredCapabilities capability = DesiredCapabilities .firefox();
	capability.setBrowserName("firefox");
	capability.setPlatform(Platform.XP);
	driver = new RemoteWebDriver(new URL(nodeURL), capability);
	}*/
	
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
	public void verifyHeaderTxt()
	{
		WebElement objHeader = driver.findElement(By.xpath("//*[text()='Challenging DOM']"));
		String strHeader = objHeader.getText();
		String strExpected = "Challenging DOM";
		assert strHeader.equals(strExpected);
		Reporter.log("String Header Text is: "+strHeader,true);
	
	}
	
	@Test(priority=4)
	public void verifyHeaderParagraph()
	{
		WebElement objHeader = driver.findElement(By.xpath("//*[starts-with(text(),'The hardest part')]"));
		String strHeader = objHeader.getText();
		String strExpected = "The hardest part in automated web testing is finding the best locators (e.g., ones that well named, unique, and unlikely to change). It's more often than not that the application you're testing was not built with this concept in mind. This example demonstrates that with unique IDs, a table with no helpful locators, and a canvas element."; 
		assert strHeader.equals(strExpected);
		Reporter.log("String Header Text is: "+strHeader,true);
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}

}

