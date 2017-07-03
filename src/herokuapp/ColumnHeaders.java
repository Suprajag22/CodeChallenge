package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ColumnHeaders 
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
			public void verifyColumnHeader() throws InterruptedException
			{
				for (int i=1;i<=7;i++)
				{
					String getHeader = driver.findElement(By.xpath("//*[@id='content']/div/div/div/div[2]/table/thead/tr/th["+i+"]")).getText();
					Reporter.log(getHeader, true);
				}
			}
			
			@Test(priority=4)
			public void closeBrowser()
			{
				driver.close();
			}

		}

