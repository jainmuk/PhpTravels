package test.PhpTravels;

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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() {

		File file = new File("L:\\gitProject\\php\\PhpTravels\\logindata.xlsx"); // creating a new file instance
		try {
			FileInputStream fis = new FileInputStream(file);// obtaining bytes from the file

			XSSFWorkbook wb = new XSSFWorkbook(fis);// creating Workbook instance that refers to .xlsx file
			XSSFSheet sheet = wb.getSheetAt(0); // creating a Sheet object to retrieve object
			Iterator<Row> itr = sheet.iterator(); // iterating over excel file rows
			itr.next();
			while (itr.hasNext()) {
				Row row = itr.next(); // fetching row data
				return new Object[][] { { String.valueOf(row.getCell(0)) }, { String.valueOf(row.getCell(1)) } };

			}
			wb.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new Object[][] { { "" }, { "" } };
	}

	@Test(dataProvider = "data-provider")
	public void myTest(String userId, String pwd) {
		System.out.println("userID : " + userId + " password: " + pwd);
	}

}
