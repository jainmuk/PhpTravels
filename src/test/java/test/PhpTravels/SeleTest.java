package test.PhpTravels;

import static org.testng.Assert.assertFalse;

import java.io.IOException;

import Base.AppTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WindowType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class  SeleTest extends AppTest {

	//This test is to test upload and download on demoQA
	@BeforeTest
	public void beforeTest() throws IOException {
		System.out.println("I am in BeforeTest");		
	}
	
	@Test(groups = "smoke")
	public void testAppTest(){
		System.out.println("I am in testAppTest");
		driver.get("https://google.com");
		}
	
	@Test(groups = "smoke")
	public void testDemoQA() throws IOException, InterruptedException {
		System.out.println("I am in SeleTest");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://demoqa.com/upload-download");
		Thread.sleep(5000);		
	}
	
	@Parameters({"url"})
	@Test(enabled = true)
	public void testIrctc(String url) {
		System.out.println("I am in testIrctc");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to(url);
	}
	
	@Test(enabled = true)
	public void testFlipkart() {
		System.out.println("I am in testFlipkart");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://rahulshettyacademy.com/seleniumPractise/#/");
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("I am in AfterTest");
		driver.close();
	}
}
