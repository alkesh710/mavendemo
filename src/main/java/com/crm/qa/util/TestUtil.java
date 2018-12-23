package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	public static long PAGE_LOAD_TIMEOUT = 30;

	public static long IMPLICIT_WAIT = 25;

	public static Workbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	XSSFCell cell;
	public static String TESTDATA_SHEET_PATH = "F:\\WORKSPACE_DECEMBER_MONTH\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testData\\alkesh.xlsx";
 public static DataFormatter formatter= new DataFormatter();
	/*
	 * public static Workbook wb; public static Sheet sheet1;
	 */

	public static void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
	
	public static  Object[][] getData(String sheetname)
	{
		File file=new File(TESTDATA_SHEET_PATH);
		FileInputStream fi=null;
		try {
			fi = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			wb = new WorkbookFactory().create(fi);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet=(XSSFSheet) wb.getSheet(sheetname);
		Object[][] data=(Object[][]) new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
			{
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
				
			}
		}
		return data;
		
	}
	
	@Test
	public void testData() {
		
	
		Object[][] obj =TestUtil.getData("contact");
		System.out.println(obj);
		
	}
	}

	/*public static Object[][] getTestData(String sheetname) throws Exception {
		File file = new File(TESTDATA_SHEET_PATH);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);

		XSSFRow row = sheet1.getRow(1);

		// int rownum=sheet1.getLastRowNum();

		Object[][] data = new Object[sheet1.getLastRowNum()][sheet1.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet1.getLastRowNum(); i++) {

			for (int k = 0; k < sheet1.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet1.getRow(i + 1).getCell(k).toString();

			}

			
		}
		return data;
	}
*/
	
/*	public static Object[][] getTestData(String sheetname) throws Exception 
	{
		File file=new File(TESTDATA_SHEET_PATH);
		FileInputStream fi=new FileInputStream(file);
	XSSFWorkbook wb=new XSSFWorkbook(fi);
	
	XSSFSheet sheet1=wb.getSheet(sheetname);
	XSSFRow row=sheet1.getRow(1);
	
	int rownum=sheet1.getLastRowNum()+1;
	int colnum=row.getLastCellNum();
	
	
	for(int i=0;i<rownum;i++)
	{
		for(int j=0;j<colnum;j++)
		{
			String data=sheet1.getRow(i).getCell(j).getStringCellValue();
		}
	}
	
	
		
	}
}*/
	
	/*
	@DataProvider
	    public static Object[][] getTestData(String sheetname) throws IOException
	    {
	    FileInputStream fileInputStream= new FileInputStream(TESTDATA_SHEET_PATH); //Excel sheet file location get mentioned here
	    XSSFWorkbook  workbook = new XSSFWorkbook (fileInputStream); //get my workbook 
	      XSSFSheet  worksheet=workbook.getSheet(sheetname);// get my sheet from workbook
	        XSSFRow Row=worksheet.getRow(0);     //get my Row which start from 0   
	     
	        int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
	        int ColNum= Row.getLastCellNum(); // get last ColNum 
	         
	        Object Data[][]= new Object[RowNum-1][ColNum]; // pass my  count data in array
	         
	            for(int i=0; i<RowNum-1; i++) //Loop work for Rows
	            {  
	                XSSFRow row= worksheet.getRow(i+1);
	                 
	                for (int j=0; j<ColNum; j++) //Loop work for colNum
	                {
	                    if(row==null)
	                        Data[i][j]= "";
	                    else
	                    {
	                        XSSFCell cell= row.getCell(j);
	                        if(cell==null)
	                            Data[i][j]= ""; //if it get Null value it pass no data 
	                        else
	                        {
	                            String value=formatter.formatCellValue(cell);
	                            Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
	                        }
	                    }
	                }
	            }
	 
	        return Data;
	*/



