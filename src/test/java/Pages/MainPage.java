package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage {
    private final WebDriver driver;
    By buttonForAddToBasket = By.xpath("//a[@class = 'product-card__add-basket j-add-to-basket btn-main']");
    By popapSizesProduct = By.xpath("//ul[@class='sizes-list j-quick-order-sizes']");
    By choiceSize = By.xpath("//label[@class ='j-quick-order-size-fake sizes-list__button']");
    By namesProductsMainPage = By.xpath("//span[@class ='product-card__name']");
    By buttonToBasket = By.xpath("//span[@class='navbar-pc__icon navbar-pc__icon--basket']");
    By priceMainPage = By.xpath("//ins[@class ='price__lower-price wallet-price']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToBasket() {
        List<WebElement> buttonsBuy = driver.findElements(buttonForAddToBasket);
        buttonsBuy.get(0).click();
        buttonsBuy.get(1).click();
        List<WebElement> sizesProducts = driver.findElements(popapSizesProduct);
        if (!sizesProducts.isEmpty()) {
            WebElement sizeFirst = sizesProducts.get(0);
            sizeFirst.click();
        }
    }

    public String getName1_MainPage() {
        List<WebElement> namesProductsMain = driver.findElements(namesProductsMainPage);
        String nameProduct1_Main = namesProductsMain.get(0).getText().replace("/ ", "");
        return nameProduct1_Main;
    }

    public String getName2_MainPage() {
        List<WebElement> namesProductsMain = driver.findElements(namesProductsMainPage);
        namesProductsMain.get(1).getText();
        String nameProduct2_Main = namesProductsMain.get(1).getText().replace("/ ", "");
        return nameProduct2_Main;
    }

    public String getPrice1_MainPage() {
        List<WebElement> namesProductsMain = driver.findElements(priceMainPage);
        namesProductsMain.get(0).getText();
        String price1_ProductMain = namesProductsMain.get(0).getText();
        return price1_ProductMain;
    }

    public String getPrice2_MainPage() {
        List<WebElement> namesProductsMain = driver.findElements(priceMainPage);
        String price2_ProductMain = namesProductsMain.get(1).getText();
        return price2_ProductMain;
    }

    public MainPage goToBasket() {
        driver.findElement(buttonToBasket).click();
        return this;
    }
}
