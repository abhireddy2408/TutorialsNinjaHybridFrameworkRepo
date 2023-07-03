package com.tutorialsninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {
	
	public static Integer IMPLICIT_WAIT_TIME = 10;
	public static Integer PAGE_LOAD_TIME = 6;
	
public static String autoEmailGenerate() {
		
		Date date = new Date();
		String autoEmail = ("abhireddy"+ date.toString().replace(' ', '_').replace(':','_')+"@gmail.com");
		return autoEmail;
		
	}

// Using Apache POI we can read Excel data for Data driven test methods
public static Object[][] getTestDataFromExcel(String sheetName) {
	

	File testDataExcel = new File(System.getProperty("user.dir")+"/src/main/java/com/tutorialsninja/qa/testdata/TutorialsNinjaTestData.xlsx");
	
	XSSFWorkbook workBook = null;
	try {
		
	FileInputStream fiss = new FileInputStream(testDataExcel);
	workBook = new XSSFWorkbook(fiss);

	}catch(Throwable e) {
		
		e.printStackTrace();
	}
	
	
	XSSFSheet sheet = workBook.getSheet(sheetName);
	
	
	int rows = sheet.getLastRowNum(); // gets the number of rows including heading
	int cols = sheet.getRow(0).getLastCellNum(); // gets the number of cell numbers
	
	
	Object[][] data = new Object[rows][cols];
	
	for(int i=0; i<rows; i++) {
		
		XSSFRow row = sheet.getRow(i+1);
		
		for(int j=0; j<cols; j++) {
			
			XSSFCell cell = row.getCell(j);
			CellType cellType = cell.getCellType();
			
			switch(cellType) {
				
				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;
					
				case NUMERIC:
					data[i][j] = Integer.toString((int)cell.getNumericCellValue());
					break;
					
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;
				default:
				break;
			
			}
		}
	}
	return data;
	
	}



	// Get Screenshot method
	
	
	public static String getScreenshot(WebDriver driver, String testName) {
		
		File srcScreenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationScreenshotPath = System.getProperty("user.dir")+"/Screenshots/"+ testName +".png";
		try {
			FileHandler.copy(srcScreenshotFile, new File(destinationScreenshotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return destinationScreenshotPath;
	}

}












