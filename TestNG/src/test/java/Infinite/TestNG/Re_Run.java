package Infinite.TestNG;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Re_Run implements IRetryAnalyzer{
	
	private int retryCount=0;
	private static final int maxCount=100;
	
	@Override
	public boolean retry(ITestResult result) {
		{
			if(retryCount<maxCount)
			{
				retryCount++;
				return true;
			}
		}
		return false;
	}

}
