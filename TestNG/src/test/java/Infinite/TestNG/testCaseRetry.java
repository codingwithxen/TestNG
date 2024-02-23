package Infinite.TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testCaseRetry {
	WebDriver driver;
	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
	}
	@Test(retryAnalyzer = Re_Run.class)
	public void Test() {
		 driver.get("https://www.google.com/");
		 WebElement SearchDABBA=driver.findElement(By.xpath("//textarea[@class=\"gLFyf\"]"));
			Actions action=new Actions(driver);
			
			Action keyInCaps=action.sendKeys(SearchDABBA,"Test 4").build();
			keyInCaps.perform();
			SearchDABBA.sendKeys(Keys.RETURN);
			WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(5));
			wait1.until(ExpectedConditions.invisibilityOf(SearchDABBA));
			String expectedTitle="Test 4 - Google Search";
			String actualTitle=driver.getTitle();
			
			
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(expectedTitle, actualTitle, "Title Check");
			driver.close();
			softAssert.assertAll();
		
		
	}

	@AfterTest
	public void AfterTest() {
	driver.close();
}
}
