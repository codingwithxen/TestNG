package Infinite.TestNG;

import java.time.Duration;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class access {
	FirefoxDriver driver;
	
	@Test(priority=0)
public void PageLoad() {
		driver.get(null);
	String s=driver.getTitle();
	String expect_s="OrangeHRM";
	if(s.equals(expect_s))
	System.out.println("-----------------Page Loaded Successfully---------------------");
	else
		System.err.println("Error in fetching the URL");
//	driver.close();
	
}
@Test(priority=1)
public void EnterCredentials() throws InterruptedException {
	
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
	WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(7));
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

	WebElement username=driver.findElement(By.name("username"));
	WebElement password=driver.findElement(By.name("password"));
	
	username.sendKeys("Admin");
	password.sendKeys("admin123");
	
	password.sendKeys(Keys.ENTER);
	
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")));
	WebElement DsBoard=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6"));
	String s=DsBoard.getText();
	if(s.contentEquals("Dashboard"))
		System.out.println("-----------------Admin Logged in Successfully-------------------");
	else
		System.err.println("failed to log in");
	
	
}
@Test(priority=2)
public void instanceClose() {
	driver.close();
}

}
