package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class VerifyFooterTxt {
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
	public void verifyFooterLink() throws InterruptedException
	{
		String strFooter = driver.findElement(By.xpath("//*[@id='page-footer']/div/div")).getText();
		Reporter.log(strFooter, true);
	}
	
	@Test(priority=4)
	public void closeBrowser()
	{
		driver.close();
	}
}

