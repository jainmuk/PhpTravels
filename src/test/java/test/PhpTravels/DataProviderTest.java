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
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import objects.Login;
import pageLocators.LoginLocators;
import utilityMethods.GetWebElement;

public class DataProviderTest extends AppTest{

	public static String Filename ="logindata.xlsx";
	Login login ;
	List<Login> listOfLoginCred = new ArrayList<Login>();		
	LoginLocators locators = new LoginLocators();
	GetWebElement gwe = new GetWebElement();
	
	public List<Login> readListOfDataFromExcel() {
		File file = new File(Filename); //creating a new file instance
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
	
	@DataProvider(name = "data-provider")
	public Object[][] dpMethod1() {
		List<Login> login =readListOfDataFromExcel();		
		Object[][]a = new Object[3][2];
		
		for(int i=0;i<login.size();i++) {
			a[i][0] =login.get(i).getUserID();
			a[i][1] = login.get(i).getPassword();
		}
		
		return a;
		
		
	}
	
	@Test(dataProvider = "data-provider")
	public void myTest(String userId, String pwd) throws InterruptedException {
		System.out.println("userID : " + userId + " \t password: " + pwd);
		driver.get("https://demo.guru99.com/test/newtours/index.php");
		gwe.GetWebPageElement(driver, locators.userId).sendKeys(userId);
		gwe.GetWebPageElement(driver, locators.password).sendKeys(pwd);
		gwe.GetWebPageElement(driver, locators.submit).click();

		String result =driver.findElement(By.xpath("//h3[text()='Login Successfully']")).getText();
		System.out.println(result);
		driver.findElement(By.xpath("//a[text()='SIGN-OFF']")).click();
		Thread.sleep(3000);
		
	}

}
