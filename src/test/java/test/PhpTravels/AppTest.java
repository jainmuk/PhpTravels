package test.PhpTravels;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class AppTest  
{
	public static WebDriver driver;


	@BeforeSuite
	public void setup() throws IOException{
		driver = WebDriverManager.chromedriver().create();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("I am in before suite");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("I am in before method");
	}

	@Test()
	public void testAppTest(){
		System.out.println("I am in testAppTest");
		driver.get("https://google.com");
		}

	
	
	@AfterSuite
	public void teardown(){
		System.out.println("I am in AfterSuite");
		driver.quit();
	}

}
