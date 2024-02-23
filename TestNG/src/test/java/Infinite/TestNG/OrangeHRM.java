package Infinite.TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class OrangeHRM {
  @Test
  public void sampleTestClass() {
	  System.out.println("Inside sampleTestClass");//5th
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Inside beforeMethod"); //4th
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Inside afterMethod");//6th
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("Inside beforeClass"); //3rd
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("Inside afterClass");//7th
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Inside beforeTest"); //2nd
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Inside afterTest");//8th
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Inside beforeSuite"); // 1st
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("Inside afterSuite");//9th
  }

}
