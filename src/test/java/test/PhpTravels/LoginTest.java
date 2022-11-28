package test.PhpTravels;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import objects.Login;
import utilityMethods.ExcelFileHandling;

public class LoginTest extends AppTest {

	public static String Filename ="logindata.xlsx";
	
	
	public LoginTest(String Filename) {
		this.Filename = Filename;
	}
	
//	@Test(groups = "test")
	public void test() throws IOException {
		FileInputStream fis = new FileInputStream(new File("logindata.xlsx"));			
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		Row r = sheet.getRow(0);
		Cell c = r.getCell(0);
		System.out.println(c);
		wb.close();
	}

	
	
	public String readParameterValueFromExcel(String parameterName) {
		File file = new File("demodata.xlsx"); //creating a new file instance
		List<String> identifiedParameterNameRowData = new ArrayList<String>();
		try {
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			int sheets = workbook.getNumberOfSheets();
			for(int sheetIndex=0;sheetIndex<sheets;sheetIndex++)
			{
				if(workbook.getSheetName(sheetIndex).equalsIgnoreCase("irctc"))
				{
					XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
					//Identify TestCases column by scanning the entire 1st row
					Iterator<Row> rows= sheet.iterator();// sheet is collection of rows
					//once column is identified then scan entire Parameter column to identify parameter key row
					while(rows.hasNext())
					{
						Row rowData=rows.next();						
						if(rowData.getCell(0).getStringCellValue().equalsIgnoreCase(parameterName))
						{							
							String rowValue = rowData.getCell(1).getStringCellValue();
							return rowValue;							
						}
					}
				}
			}
			workbook.close();
			System.out.println(identifiedParameterNameRowData.toString());			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "check your excel spreadsheet";
	}

	@Test
	public void login() {	
		List<Login> listOfLoginCred = ExcelFileHandling.readListOfDataFromExcel();
		int listCount = listOfLoginCred.size();
		for(int i=0;i<listCount;i++) {
			System.out.println(listOfLoginCred.get(i).toString());
		}
		
//		String lastName = readParameterValueFromExcel("lastName");
//		System.out.println(lastName);
	}
}
