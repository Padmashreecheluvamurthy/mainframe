package practice.sdet31;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibTest {
	
	public  String getExcelData(String sheetName, int row, int col) throws Throwable, IOException
	{
	 FileInputStream fis = new FileInputStream("G:\\test1.xlsx");
	 Workbook wb = WorkbookFactory.create(fis);
	 Sheet sh = wb.getSheet(sheetName);
	 Row r =sh.getRow(row);
	 String data=r.getCell(col).getStringCellValue();
	 return data;
	 
	 
		
	}

}
