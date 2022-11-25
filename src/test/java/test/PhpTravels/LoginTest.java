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

public class LoginTest extends AppTest {

	public String Filename ="logindata.xlsx";
	Login login ;
	List<Login> listOfLoginCred = new ArrayList<Login>();
	
	public LoginTest(String Filename) {
		this.Filename = Filename;
	}

	public void readListOfDataFromExcel() {
		File file = new File("logindata.xlsx"); //creating a new file instance
		try {
			FileInputStream fis = new FileInputStream(file);//obtaining bytes from the file 			
			XSSFWorkbook wb = new XSSFWorkbook(fis);//creating Workbook instance that refers to .xlsx file  
			XSSFSheet sheet = wb.getSheetAt(0);  //creating a Sheet object to retrieve object  
			Iterator<Row> itr = sheet.iterator(); //iterating over excel file rows
			itr.next();
			while (itr.hasNext()) {
				Row row = itr.next();  //fetching row data
				login = new Login(String.valueOf(row.getCell(0)),String.valueOf(row.getCell(1)));				
				listOfLoginCred.add(login);
			}
			wb.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		readListOfDataFromExcel();
		int listCount = listOfLoginCred.size();
		for(int i=0;i<listCount;i++) {
			System.out.println(listOfLoginCred.get(i).toString());
		}
		
		String lastName = readParameterValueFromExcel("lastName");
		System.out.println(lastName);
	}
}
