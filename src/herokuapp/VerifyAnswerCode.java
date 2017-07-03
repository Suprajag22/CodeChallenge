package herokuapp;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class VerifyAnswerCode {
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
	public void verifyCode() throws InterruptedException
	{
		//scroll the page
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(3000);
		String strAll = driver.getPageSource();
		System.out.println(strAll);
		//int Pos = strAll.indexOf("Answer");
		//String RequiredTxt = strAll.substring(Pos, 9);
		//System.out.println(RequiredTxt);
	}
	
	@Test(priority=4)
	public void closeBrowser()
	{
		driver.close();
	}
}
