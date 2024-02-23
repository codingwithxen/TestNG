package Infinite.TestNG;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class firstTest {

//	public void TestGoogle() throws Exception{
//		WebDriverManager.chromedriver().setup();
//		ChromeDriver driver=new ChromeDriver();
//		driver.get("https://www.google.com/");
//		
//	
//	
//	
//	}
	
	@DataProvider(name = "userData")
    public Object[][] userDataProvider() throws IOException {
        String csvFilePath = "C:\\Users\\ranjuh\\Desktop\\Data_Fetch.csv";

        List<Object[]> testData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                testData.add(data);
            }
        }

        return testData.toArray(new Object[0][]);
    }
}
