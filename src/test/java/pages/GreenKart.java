package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Base.AppTest;

public class GreenKart extends AppTest {

    public String logo;

    public WebElement addToKart(){
        return driver.findElement(By.xpath("//button[contains(text(), 'ADD TO CART')]"))  ;
    }

    public WebElement item(String product){
        return driver.findElement(By.xpath("//div/h4[contains(text(),'"+product+"')]/following-sibling::div/button[contains(text(),'ADD TO CART')]")) ;
    }

    public WebElement cartIcon(){
        return driver.findElement(By.cssSelector("a.cart-icon > img"));
    }
    public WebElement proceedToCheckOut(){
        return driver.findElement(By.xpath("//div[@class='action-block']/button[text()='PROCEED TO CHECKOUT']"));
    }
   public void addProductToKarts(String arr[])  {
       driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
       driver.manage().window().maximize();
       for(int i=0;i<arr.length;i++){
           item(arr[i]).click();
       }
   }


}
