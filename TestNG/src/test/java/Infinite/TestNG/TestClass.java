package Infinite.TestNG;

import java.time.Duration;

import org.hamcrest.Factory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass {
	
	 FirefoxDriver driver;
	@BeforeSuite
public void PageLoad() {
	WebDriverManager.firefoxdriver().setup();
	
	driver=new FirefoxDriver();
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	String s=driver.getTitle();
	String expect_s="OrangeHRM";
	if(s.equals(expect_s))
	System.out.println("-----------------Page Loaded Successfully---------------------");
	else
		System.err.println("Error in fetching the URL");
	
}
@Test(dataProvider = "getData", dataProviderClass=DataFetcher.class)
public void EnterCredentials(String userName,String passWord) throws InterruptedException {
	
//	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
	driver.get("https://practicetestautomation.com/practice-test-login/");
	WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(7));
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='username']")));
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

//	WebElement username=driver.findElement(By.name("username"));
	WebElement username=driver.findElement(By.xpath("//*[@id='username']"));
	WebElement password=driver.findElement(By.xpath("//*[@id=\"password\"]"));
//	WebElement password=driver.findElement(By.name("password"));
	
	username.sendKeys(userName);
	password.sendKeys(passWord);
	
	WebElement clicker=driver.findElement(By.xpath("//*[@id='form']//button"));
	
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click()",clicker);
	
//	password.sendKeys(Keys.ENTER);
	
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='post-header']//h1")));
	WebElement DsBoard=driver.findElement(By.xpath("//*[@class='post-header']//h1"));
	String s=DsBoard.getText();
	if(s.contentEquals("Logged In Successfully"))
		System.out.println("-----------------Admin Logged in Successfully-------------------");
	else
		System.err.println("failed to log in");
	
	
}


@AfterSuite
public void instanceClose() {
	driver.close();
}

}

