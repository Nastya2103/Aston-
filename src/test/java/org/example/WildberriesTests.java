package org.example;

import Pages.BasketPage;
import Pages.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class WildberriesTests extends BaseTest {
    MainPage mainPage = new MainPage(DriverSingleton.getInstance());
    BasketPage basketPage = new BasketPage(DriverSingleton.getInstance());

    @Test(priority = 1)
    public void testNamesAndPrices() throws InterruptedException {
        mainPage.addProductToBasket();
        Thread.sleep(1000);
        String name1_Main = mainPage.getName1_MainPage();
        String name2_Main = mainPage.getName2_MainPage();
        String price_1Main = mainPage.getPrice1_MainPage();
        String price_2Main = mainPage.getPrice2_MainPage();
        Thread.sleep(1000);
        mainPage.goToBasket();
        Thread.sleep(1000);
        String name1_Basket = basketPage.getName1_InBasket();
        String name2_inBasket = basketPage.getName2_InBasket();
        String price1_Basket = basketPage.getPrice1_BasketPage();
        String price2_Basket = basketPage.getPrice2_BasketPage();
        Thread.sleep(1000);

        Assert.assertEquals(name1_Main, name1_Basket);
        Assert.assertEquals(name2_Main, name2_inBasket);
        Assert.assertEquals(price_1Main, price1_Basket);
        Assert.assertEquals(price_2Main, price2_Basket);
    }

    @Test(priority = 2)
    public void testAmountProducts() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        mainPage.addProductToBasket();
        mainPage.goToBasket();
        basketPage.plusCount();
        Thread.sleep(3000);
        WebElement amountProduct = driver.findElement(By.xpath("//input[@type ='number']"));
        String value = (String) js.executeScript("return arguments[0].value;", amountProduct);
        Integer actualAmount = Integer.valueOf(value);
        Integer expectedAmount = 2;
        String extendTotalCost = basketPage.getTotalCost();
        String actualTotalCost = basketPage.getTotalCost();

        Assert.assertEquals(actualTotalCost, extendTotalCost);
        Assert.assertEquals(expectedAmount, actualAmount);
    }
}
