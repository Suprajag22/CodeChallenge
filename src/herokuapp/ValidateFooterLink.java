package herokuapp;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ValidateFooterLink
{
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
	public void verifyFooterLnk() throws InterruptedException
	{
		driver.findElement(By.linkText("Elemental Selenium")).click();
		Thread.sleep(4000);
		String ParentWindow = driver.getWindowHandle();
		String ChildWindow = "";
				
		Set<String> allWindows = driver.getWindowHandles();
		
		//for(datatype variable_name: collections
		for(String element:allWindows)
		{
			if(element.equals(ParentWindow)==false)
			{
				ChildWindow = element;
			}
		}
		
		driver.switchTo().window(ChildWindow);
		String strChildWndTitle = driver.getTitle();	
		Reporter.log("Footer window title is: "+strChildWndTitle, true);
		
		driver.switchTo().window(ParentWindow);
		String strParentWndTitle = driver.getTitle();
		Reporter.log("Home Page window title is: "+strParentWndTitle, true);
	}
	
	@Test(priority=4)
	public void closeBrowser()
	{
		driver.quit();
	}

}
