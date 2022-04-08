package com.crm.autodesk.genericUtilities;

import java.io.FileInputStream;

//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * It is developed using Apache Poi libraries , 
 * which is used to handle Microsoft Excel Sheet
 * @author Padmashree
 * 
 *
 */

public class ExcelUtility {
	
	/**
	 * it is used to get data from excel based on below arguments
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return Data
	 * @throws Throwable
	 */
	public String getDataFromExcel(String sheetname, int rowNum, int cellNum)
			throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstants.EXCEL_PATH);
		Workbook wb = WorkbookFactory.create(fis);
		String data= wb.getSheet(sheetname).getRow(rowNum).getCell(cellNum).getStringCellValue();
		
		return data;
	}
	
	
	
	
		
		
	}


