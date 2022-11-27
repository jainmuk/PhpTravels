package utilityMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetWebElement {

	 public WebElement GetWebPageElement(WebDriver d, By object) {
		  
		  return d.findElement(object);
	  }
}
