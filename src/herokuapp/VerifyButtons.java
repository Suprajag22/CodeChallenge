package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class VerifyButtons {
	WebDriver driver;

	@Test(priority=1)
	public void launchApp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/challenging_dom");
	}
	
	@Test(priority=2)
	public void maximizeApp() throws InterruptedException
	{
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	
	
	@Test(priority=3)
	public void validateButtons()
	{
		WebElement Btn1 = driver.findElement(By.xpath("//*[@class='button']"));
		WebElement Btn2 = driver.findElement(By.xpath("//*[@class='button alert']"));
		WebElement Btn3 = driver.findElement(By.xpath("//*[@class='button success']"));
		
		String strBtn1 = Btn1.getText();
		String strbgColor1 = Btn1.getCssValue("background-color");
		
		String strBtn2 = Btn2.getText();
		String strbgColor2 = Btn2.getCssValue("background-color");
		
		String strBtn3 = Btn3.getText();
		String strbgColor3 = Btn3.getCssValue("background-color");
		
		Reporter.log("First Button Name is: "+strBtn1+" & background color is: "+strbgColor1, true);
		Reporter.log("Second Button Name is: "+strBtn2+" & background color is: "+strbgColor2, true);
		Reporter.log("Third Button Name is: "+strBtn3+" & background color is: "+strbgColor3, true);
	}
	
	@Test(priority=4)
	public void closeBrowser()
	{
		driver.close();
	}
}
