package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import Base.AppTest;

public class ChooseCountry extends AppTest {

    By proceed = By.xpath("//button[text()='Proceed']");
    public void selectCountry(){
        WebElement dropDown = driver.findElement(By.xpath("//div/select"));
        Select select = new Select(dropDown);
        select.selectByValue("India");
    }

    public WebElement checkBox(){
        return driver.findElement(By.xpath("//input[@class='chkAgree']"));
    }

    public WebElement proceedButton(){
      return  driver.findElement(proceed);
    }
}
