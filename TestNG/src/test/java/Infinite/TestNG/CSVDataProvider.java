package Infinite.TestNG;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CSVDataProvider {
	@DataProvider(name = "csvDataProvider")
    public Object[][] readDataFromCSV() throws IOException {
        String csvFilePath = "C:\\Users\\ranjuh\\Desktop\\Data_Fetch.csv";
        BufferedReader br = new BufferedReader(new FileReader(csvFilePath));
        String line;
        int lines = 0;
        while (br.readLine() != null) lines++;
        br.close();

        Object[][] data = new Object[lines][];
        br = new BufferedReader(new FileReader(csvFilePath));
        int row = 0;
        while ((line = br.readLine()) != null) {
            String[] fields = line.split(",");
            data[row] = fields;
            row++;
        }
        br.close();
        return data;
    }

    @Test(dataProvider = "getData",dataProviderClass =ExcelDataProvider.class)
    public void testWithDataFromCSV(String param1, String param2) {
        System.out.println("Parameter 1: " + param1);
        System.out.println("Parameter 2: " + param2);
    }
}
