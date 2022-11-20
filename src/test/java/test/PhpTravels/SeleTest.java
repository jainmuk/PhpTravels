package test.PhpTravels;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleTest extends AppTest {

	
	@BeforeTest
	public void beforeTest() throws IOException {
		System.out.println("I am in BeforeTest");		
	}
	@Test()
	public void testSeleTest() throws IOException, InterruptedException {
		System.out.println("I am in SeleTest");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://demoqa.com/upload-download");
		Thread.sleep(5000);		
	}
	@AfterTest
	public void tearDown() {
		System.out.println("I am in AfterTest");
		driver.close();
	}
}
