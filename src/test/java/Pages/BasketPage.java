package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasketPage {
    private WebDriver driver;
    By namesProductInBasket = By.xpath("//span[@class ='good-info__good-name']");
    By priceInBasketWB = By.xpath("//div[@class ='list-item__price-wallet']");
    By priceBasket = By.xpath("//div[@class='list-item__price-new wallet']");
    By totalCost = By.xpath("//p[@class='b-top__total line']//span[@data-link]");
    By amountOfProduct = By.xpath("//input[@type ='number']");
    By buttonCountPlus = By.xpath("//button[@class = 'count__plus plus']");

    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getName1_InBasket() {
        List<WebElement> namesProductsBasket = driver.findElements(namesProductInBasket);
        String name1_Basket = namesProductsBasket.get(1).getText();
        /*for (WebElement nameProduct : namesProductsBasket) {
            nameProduct.getText();
        }*/
        return name1_Basket;
    }

    public String getName2_InBasket() {
        List<WebElement> namesProductsBasket = driver.findElements(namesProductInBasket);
        namesProductsBasket.get(0).getText();
        String name2_Basket = namesProductsBasket.get(0).getText();
        return name2_Basket;
    }

    public String getPrice1_BasketPage() {
        List<WebElement> pricesProductsBasket = driver.findElements(priceInBasketWB);
        String price1_Basket = pricesProductsBasket.get(1).getText();
        return price1_Basket;
    }

    public String getPrice2_BasketPage() {
        List<WebElement> pricesProductsBasketWB = driver.findElements(priceInBasketWB);
        String price2_Basket = pricesProductsBasketWB.get(0).getText();
        return price2_Basket;
    }

    public String getTotalCount() {
        List<WebElement> pricesProducts = driver.findElements(priceBasket);
        String price_1 = pricesProducts.get(0).getText().replace(" ₽", "");
        String price_2 = pricesProducts.get(1).getText().replace(" ₽", "");
        Integer a = Integer.valueOf(price_1);
        Integer b = Integer.valueOf(price_2);
        int valueTotal = a + b;
        String valueTotalBasket = String.valueOf(valueTotal);
        return valueTotalBasket;
    }

    public BasketPage plusCount() {
        driver.findElement(buttonCountPlus).click();
        return this;
    }

    public String getTotalCost() {
        String costTotal = driver.findElement(totalCost).getText();
        return costTotal;
    }
}
