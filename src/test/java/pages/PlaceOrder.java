package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Base.AppTest;

public class PlaceOrder extends AppTest {

    int sum =  0;
    public int totalSum(int count){
        for(int i=1;i<=count;i++){
            String value = driver.findElement(By.xpath("//tbody/tr["+i+"]/td[5]/p")).getText();
            int valueOfProduct = Integer.parseInt(value);
            sum = sum + valueOfProduct;
        }
        return sum;
    }

    public int totalAmount(){
        String totalAmount = driver.findElement(By.xpath("//span[@class='discountAmt']")).getText();
        int totalAmountValue = Integer.parseInt(totalAmount);
        return totalAmountValue;
    }

    public WebElement placeOrderButton(){
        return driver.findElement(By.xpath("//button[text()='Place Order']"));
    }
}
