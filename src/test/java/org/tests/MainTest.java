package org.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class MainTest extends BaseTest {

    @Test(priority = 1)
    public static void checkLogoText() throws InterruptedException {
        WebElement blockText = driver.findElement(By.xpath("//section[@class='pay']/div/h2"));
        String expectedText = "Онлайн пополнение\nбез комиссии";
        Assert.assertEquals(blockText.getText(), expectedText);
    }

    @Test(priority = 2)
    public static void checkLogosPartners() throws InterruptedException {
        List<WebElement> payPartnersLogos = driver.findElements(By.xpath("//div[@class='pay__partners']"));
        Assert.assertFalse(payPartnersLogos.isEmpty());
    }

    @Test(priority = 3)
    public static void checkLink() throws InterruptedException {
        WebElement linkAboutService = driver.findElement(By.xpath("//section[@class='pay']/div/a"));
        linkAboutService.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("poryadok-oplaty-i-bezopasnost-internet-platezhey"));
    }

    @Test(priority = 4)
    public static void checkFieldsAndButtonContinue() throws InterruptedException {
        WebElement communicationServicesField = driver.findElement(By.xpath("//*[@id='pay']"));
        WebElement phoneField = driver.findElement(By.xpath("//*[@id = 'connection-phone']"));
        WebElement amoundField = driver.findElement(By.xpath("//*[@id = 'connection-sum']"));
        WebElement buttonContinue = driver.findElement(By.xpath("//*[@id ='pay-connection']/button"));

        Select communicationServicesFieldSelect = new Select(communicationServicesField);
        communicationServicesFieldSelect.selectByVisibleText("Услуги связи");
        phoneField.sendKeys("297777777");
        amoundField.sendKeys("65");
        buttonContinue.click();

        WebElement iframe = driver.findElement(By.xpath("//iframe[@class = 'bepaid-iframe']"));
        driver.switchTo().frame(iframe);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean isPopupVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='app-wrapper']"))) != null;
    }
}
