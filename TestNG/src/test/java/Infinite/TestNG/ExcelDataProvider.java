package Infinite.TestNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
	@DataProvider
	public Object[][] getData() throws Exception{
			File excelFile=new File("C:\\Users\\ranjuh\\Desktop\\Data_Fetch.xlsx");
			System.out.println(excelFile.exists());
			
			FileInputStream fis=new FileInputStream(excelFile);
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			XSSFSheet sheet=workbook.getSheet("Data_Fetch");
			int noOfrows=sheet.getPhysicalNumberOfRows();
			int noOfColoumns=sheet.getRow(0).getLastCellNum();
			
			String[][] data= new String[noOfrows][noOfColoumns];
			for(int i=1;i<noOfrows;i++) {
				for(int j=0;j<noOfColoumns;j++) {
					DataFormatter dtf=new DataFormatter();
					data[i][j]=dtf.formatCellValue(sheet.getRow(i).getCell(j));
//					dtf.formatCellValue(sheet.getRow(i).getCell(j));
//					System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
				}
//				System.out.println();
				
			}
				
			workbook.close();
			fis.close();
//			for (String[] stringarray : data) {
//				System.out.println(Arrays.toString(stringarray));
//				
//			}
			return data;
	}

}
