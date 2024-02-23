package Infinite.TestNG;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleCheck {
@Test	
 public void Check1() {
	 WebDriverManager.firefoxdriver().setup();
	 FirefoxDriver driver=new FirefoxDriver();
	 driver.get("https://www.google.com/");
	 WebElement SearchDABBA=driver.findElement(By.xpath("//textarea[@class=\"gLFyf\"]"));
		

			SearchDABBA.sendKeys("ferrari");
			SearchDABBA.sendKeys(Keys.RETURN);
			String expectedTitle="ferrari - Googuley Search";
			
			WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(5));
			wait1.until(ExpectedConditions.invisibilityOf(SearchDABBA));
			
			String actualTitle=driver.getTitle();
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(actualTitle, expectedTitle,"bhul bhal Title");
	
		driver.close();
		softAssert.assertAll();
 }
}
