package Infinite.TestNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataFetcher {
	@DataProvider
public Object[][] getData() throws IOException,Exception{
	File excelFile=new File("C:\\Users\\ranjuh\\Desktop\\Data_Fetch.xlsx");
	System.out.println(excelFile.exists());
	
	FileInputStream fis=new FileInputStream(excelFile);
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	XSSFSheet sheet=workbook.getSheet("Data_Fetch");
	
	int noOfRows=sheet.getPhysicalNumberOfRows();
	int noOfColoumns=sheet.getRow(0).getLastCellNum();
	
	String[][] data= new String[noOfRows][noOfColoumns];
	
	for(int i=0;i<noOfRows;i++)
	{
		for(int j=0;j<noOfColoumns;j++) {
			DataFormatter df=new DataFormatter();
			data[i][j]=df.formatCellValue(sheet.getRow(i).getCell(j));
			System.out.println(data[i][j]);
			
		}
		System.out.println();
	}
	workbook.close();
	fis.close();
	
	
	return data;
}
}
