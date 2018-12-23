package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelBYalkesh {
	public void data() throws IOException
	{
		File file =new File("F:\\WORKSPACE_DECEMBER_MONTH\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testData\\alkesh.xlsx");
		FileInputStream fis=new FileInputStream(file);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		
		String data=sheet.getRow(0).getCell(0).getStringCellValue();
		System.out.println(data);
		
		
		
	}
	
	

}
