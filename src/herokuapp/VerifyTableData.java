package herokuapp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class VerifyTableData {
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
	public void verifyTableData() throws InterruptedException
	{	
		List<WebElement> tbl= driver.findElements(By.tagName("table"));
		List<WebElement> row = tbl.get(0).findElements(By.tagName("tr"));
		List<WebElement> cols = row.get(2).findElements(By.tagName("td"));
		int intRows = row.size();
		int intCols = cols.size();
		
		for(int i=1;i<intRows;i++)
		{
			Reporter.log("==============Row:"+i+" Data================", true);
			for(int j=1;j<=intCols;j++)
			{
				String strCellData = driver.findElement(By.xpath("//*[@id='content']/div/div/div/div[2]/table/tbody/tr["+i+"]/td["+j+"]")).getText();
				Reporter.log(strCellData, true);		
			}
		}			
	}
	
	@Test(priority=4)
	public void closeBrowser()
	{
		driver.close();
	}
	
}

