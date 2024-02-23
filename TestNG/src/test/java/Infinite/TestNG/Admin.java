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

public class Admin {
//@Test(groups="gcheck")
// public void GoogleCheck1() {
//	 WebDriverManager.firefoxdriver().setup();
//	 FirefoxDriver driver=new FirefoxDriver();
//	 driver.get("https://www.google.com/");
//	 WebElement SearchDABBA=driver.findElement(By.xpath("//textarea[@class=\"gLFyf\"]"));
//		Actions action=new Actions(driver);
//		
//		Action keyInCaps=action.sendKeys(SearchDABBA,"Test 1 ").build();
//		keyInCaps.perform();
//		SearchDABBA.sendKeys(Keys.RETURN);
//		driver.close();
//	
//		
// }
//@Test(groups="gcheck")
//public void GoogleCheck2() {
//	 WebDriverManager.firefoxdriver().setup();
//	 FirefoxDriver driver=new FirefoxDriver();
//	 driver.get("https://www.google.com/");
//	 WebElement SearchDABBA=driver.findElement(By.xpath("//textarea[@class=\"gLFyf\"]"));
//		Actions action=new Actions(driver);
//		
//		Action keyInCaps=action.sendKeys(SearchDABBA,"Test 2").build();
//		keyInCaps.perform();
//		SearchDABBA.sendKeys(Keys.RETURN);
//		driver.close();
//}
//@Test(groups="gcheck")
//public void GoogleCheck3() {
//	 WebDriverManager.firefoxdriver().setup();
//	 FirefoxDriver driver=new FirefoxDriver();
//	 driver.get("https://www.google.com/");
//	 WebElement SearchDABBA=driver.findElement(By.xpath("//textarea[@class=\"gLFyf\"]/"));
//		Actions action=new Actions(driver);
//		
//		Action keyInCaps=action.sendKeys(SearchDABBA,"Test 3").build();
//		keyInCaps.perform();
//		SearchDABBA.sendKeys(Keys.RETURN);
//		driver.close();
//}
@Test(timeOut=7000)
public void GoogleCheck4() {
	 WebDriverManager.firefoxdriver().setup();
	 FirefoxDriver driver=new FirefoxDriver();
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


}
