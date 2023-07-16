package test.PhpTravels;

import Base.AppTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ChooseCountry;
import pages.GreenKart;
import pages.PlaceOrder;

public class GreenKartTests extends AppTest {

    public String arr[] = {"Carrot","Cauliflower","Mushroom","Banana","Onion","Corn","Mango","Cashews"};
    GreenKart greenKart = new GreenKart();
    PlaceOrder placeOrder = new PlaceOrder();
    ChooseCountry chooseCountry = new ChooseCountry();
    String success = "Thank you, your order has been placed successfully\n" +
            "You'll be redirected to Home page shortly!!";
    @Test
    public void test1() throws InterruptedException {
        greenKart.addProductToKarts(arr);
        greenKart.cartIcon().click();
        greenKart.proceedToCheckOut().click();
        Assert.assertEquals(placeOrder.totalAmount(),placeOrder.totalSum(arr.length),"Sum is not equal");
        placeOrder.placeOrderButton().click();
        Thread.sleep(5000);
        chooseCountry.selectCountry();
        Thread.sleep(5000);
        chooseCountry.checkBox().click();
        chooseCountry.proceedButton().click();
        Thread.sleep(5000);
    }
}
