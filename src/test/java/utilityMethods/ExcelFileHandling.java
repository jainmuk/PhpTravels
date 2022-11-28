package utilityMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import objects.Login;

public class ExcelFileHandling {

	private static Login login ;
	private static List<Login> listOfLoginCred = new ArrayList<Login>();
	public static List<Login> readListOfDataFromExcel() {
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
		
		return listOfLoginCred;
	}
}
