package Infinite.TestNG;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomTestListener.class)
public class ExampleTestClass {
	 @Test
	    public void testMethod1() {
	        System.out.println("Executing test method 1...");
	    }

	    @Test
	    public void testMethod2() {
	        System.out.println("Executing test method 2...");
	    }
}
