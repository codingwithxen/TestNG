package Infinite.TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class CrossBrowserTesting {
	
	WebDriver driver;
	@BeforeTest
	@Parameters("browser")
public void BrowserChoice(String browser) throws Exception {
	
	if(browser.equalsIgnoreCase("Chrome"))
		driver=new ChromeDriver();
	else if(browser.equalsIgnoreCase("Firefox"))
		driver=new FirefoxDriver();
	else if(browser.equalsIgnoreCase("Edge"))
		driver=new EdgeDriver();
	else
		throw new Exception("Incorrect Browser");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
}	@Test
	 public void googleSearch() {
		driver.get("https://www.google.com/");
		 WebElement SearchDABBA=driver.findElement(By.xpath("//textarea[@class=\"gLFyf\"]"));
			

				SearchDABBA.sendKeys("ferrari");
				SearchDABBA.sendKeys(Keys.RETURN);
				String expectedTitle="ferrari - Google Search";
				
				WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(5));
				wait1.until(ExpectedConditions.invisibilityOf(SearchDABBA));
				
				String actualTitle=driver.getTitle();
				SoftAssert softAssert = new SoftAssert();
				softAssert.assertEquals(actualTitle, expectedTitle,"bhul bhal Title");
		
			driver.close();
			softAssert.assertAll();
	}
	
	
}
