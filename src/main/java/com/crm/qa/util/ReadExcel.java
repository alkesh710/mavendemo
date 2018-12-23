package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel 
{
	
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	//String filePath ="F:/WORKSPACE_DECEMBER_MONTH/FreeCRMTest/src/main/java/com/crm/qa/testData/alkesh.xlsx";
	
	public ReadExcel(int sheetNumber) 
	{
		try 
		{
			File file=new File("C://Users//admin//Desktop//alkesh.xlsx");
			fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheetAt(sheetNumber);
		} catch (Exception e) 
		{
			e.printStackTrace();
		} 
	}
	
	public String getData(int rowNum, int colNum)
	{
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		String data = cell.getStringCellValue();
		return data;
	}
	
	public static void main(String[] args)
	{
		ReadExcel reader = new ReadExcel(0);
		System.out.println(reader.getData(1, 1));
		
	}

}
