package test.PhpTravels;

import static org.testng.Assert.assertFalse;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.Parameters;  
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class SeleTest extends AppTest {

	//This test is to test upload and download on demoQA
	@BeforeTest
	public void beforeTest() throws IOException {
		System.out.println("I am in BeforeTest");		
	}
	@Test()
	public void testSeleTest() throws IOException, InterruptedException {
		System.out.println("I am in SeleTest");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://demoqa.com/upload-download");
		assertFalse(true);
		Thread.sleep(5000);		
	}
	
	@Parameters({"url"})
	@Test()
	public void testIrctc(String url) {
		System.out.println("I am in testIrctc");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to(url);
	}
	
	@Test(enabled = false)
	public void testFlipkart() {
		System.out.println("I am in testFlipkart");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://flipkart.com");
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("I am in AfterTest");
		driver.close();
	}
}
