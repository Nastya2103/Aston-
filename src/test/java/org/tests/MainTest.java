package org.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class MainTest extends BaseTest {

    @Test(priority = 1)
    public static void checkNamesOfFields() {
        WebElement communicationServicesField = driver.findElement(By.xpath("//select[@id='pay']"));
        Select communicationServicesFieldSelect = new Select(communicationServicesField);
        communicationServicesFieldSelect.selectByVisibleText("Услуги связи");
        String actualPlaceholderPhoneFieldCS = driver.findElement(By.xpath("//input[@id = 'connection-phone']")).getAttribute("placeholder");
        String expectedPlaceholderPhoneFieldCS = "Номер телефона";
        String actualPlaceholderAmountFieldCS = driver.findElement(By.xpath("//input[@id = 'connection-sum']")).getAttribute("placeholder");
        String expectedPlaceholderAmountFieldCS = "Сумма";
        String actualPlaceholderEmailFieldCS = driver.findElement(By.xpath("//input[@id = 'connection-email']")).getAttribute("placeholder");
        String expectedPlaceholderEmailFieldCS = "E-mail для отправки чека";
        driver.findElement(By.xpath("//div[@class ='select__wrapper']")).click();
        WebElement choiceHomeInternet = driver.findElement(By.xpath("//li[@class ='select__item']/p[text() = \"Домашний интернет\"]"));
        choiceHomeInternet.click();
        String expectedTextFieldHomeInternet = "Домашний интернет";
        String actualPlaceholderPhoneFieldInt = driver.findElement(By.xpath("//input[@id = 'internet-phone']")).getAttribute("placeholder");
        String expectedPlaceholderPhoneFieldInt = "Номер абонента";
        String actualPlaceholderAmountFieldInt = driver.findElement(By.xpath("//input[@id = 'internet-sum']")).getAttribute("placeholder");
        String expectedPlaceholderAmountFieldInt = "Сумма";
        String actualPlaceholderEmailFieldInt = driver.findElement(By.xpath("//input[@id = 'internet-email']")).getAttribute("placeholder");
        String expectedPlaceholderEmailFieldInt = "E-mail для отправки чека";
        driver.findElement(By.xpath("//div[@class ='select__wrapper']")).click();
        WebElement choiceInstallmentPlan = driver.findElement(By.xpath("//li[@class ='select__item']/p[text() = \"Рассрочка\"]"));
        choiceInstallmentPlan.click();
        String expectedTextFieldInstallmentPlan = "Рассрочка";
        String actualPlaceholderAccNumberInst = driver.findElement(By.xpath("//input[@id =\"score-instalment\"]")).getAttribute("placeholder");
        String expectedPlaceholderAccNumberInst = "Номер счета на 44";
        String actualPlaceholderAmountFieldInst = driver.findElement(By.xpath("//input[@id =\"instalment-sum\"]")).getAttribute("placeholder");
        String expectedPlaceholderAmountFieldInst = "Сумма";
        String actualPlaceholderEmailFieldInst = driver.findElement(By.xpath("//input[@id =\"instalment-email\"]")).getAttribute("placeholder");
        String expectedPlaceholderEmailFieldInst = "E-mail для отправки чека";
        driver.findElement(By.xpath("//div[@class ='select__wrapper']")).click();
        WebElement choiceDebt = driver.findElement(By.xpath("//li[@class ='select__item']/p[text() = \"Задолженность\"]"));
        choiceDebt.click();
        String expectedTextFieldDebt = "Задолженность";
        String actualPlaceholderAccNumberDebt = driver.findElement(By.xpath("//input[@id = \"score-arrears\"]")).getAttribute("placeholder");
        String expectedPlaceholderAccNumberDebt = "Номер счета на 2073";
        String actualPlaceholderAmountFieldDebt = driver.findElement(By.xpath("//input[@id = \"arrears-sum\"]")).getAttribute("placeholder");
        String expectedPlaceholderAmountFieldDebt = "Сумма";
        String actualPlaceholderEmailFieldDebt = driver.findElement(By.xpath("//input[@id = \"arrears-email\"]")).getAttribute("placeholder");
        String expectedPlaceholderEmailFieldDebt = "E-mail для отправки чека";

        Assert.assertEquals(actualPlaceholderPhoneFieldCS, expectedPlaceholderPhoneFieldCS);
        Assert.assertEquals(actualPlaceholderAmountFieldCS, expectedPlaceholderAmountFieldCS);
        Assert.assertEquals(actualPlaceholderEmailFieldCS, expectedPlaceholderEmailFieldCS);
        Assert.assertEquals(choiceHomeInternet.getText(), expectedTextFieldHomeInternet);
        Assert.assertEquals(actualPlaceholderPhoneFieldInt, expectedPlaceholderPhoneFieldInt);
        Assert.assertEquals(actualPlaceholderAmountFieldInt, expectedPlaceholderAmountFieldInt);
        Assert.assertEquals(actualPlaceholderEmailFieldInt, expectedPlaceholderEmailFieldInt);
        Assert.assertEquals(choiceInstallmentPlan.getText(), expectedTextFieldInstallmentPlan);
        Assert.assertEquals(actualPlaceholderAccNumberInst, expectedPlaceholderAccNumberInst);
        Assert.assertEquals(actualPlaceholderAmountFieldInst, expectedPlaceholderAmountFieldInst);
        Assert.assertEquals(actualPlaceholderEmailFieldInst, expectedPlaceholderEmailFieldInst);
        Assert.assertEquals(choiceDebt.getText(), expectedTextFieldDebt);
        Assert.assertEquals(actualPlaceholderAccNumberDebt, expectedPlaceholderAccNumberDebt);
        Assert.assertEquals(actualPlaceholderAmountFieldDebt, expectedPlaceholderAmountFieldDebt);
        Assert.assertEquals(actualPlaceholderEmailFieldDebt, expectedPlaceholderEmailFieldDebt);
    }

    @Test(priority = 2)
    public static void checkPopup() {
        WebElement phoneField = driver.findElement(By.xpath("//*[@id = 'connection-phone']"));
        WebElement amountField = driver.findElement(By.xpath("//*[@id = 'connection-sum']"));
        WebElement buttonContinue = driver.findElement(By.xpath("//*[@id ='pay-connection']/button"));
        String valueNumberPhone = "297777777";
        phoneField.sendKeys(valueNumberPhone);
        String valueAmount = "65";
        amountField.sendKeys(valueAmount);
        buttonContinue.click();
        WebElement iframe = driver.findElement(By.xpath("//iframe[@class = 'bepaid-iframe']"));
        driver.switchTo().frame(iframe);
        String placeholderCardNumber = "Номер карты";
        String placeholderValidity = "Срок действия";
        String placeholderCVC = "CVC";
        String placeholderNameUserCard = "Имя держателя (как на карте)";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));

        boolean checkAmountPopup = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class = 'header__payment-amount']/span"), valueAmount));
        boolean checkNumberPhone = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//p[@class = 'header__payment-info']"), valueNumberPhone));
        boolean checkTextButtonOfPay = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//button[text() = ' Оплатить  65.00 BYN ']"), valueAmount));
        boolean placeholderCardNumberField = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//label[@class= 'ng-tns-c49-1 ng-star-inserted']"), placeholderCardNumber));
        boolean placeholderValidityField = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//label[@class ='ng-tns-c49-4 ng-star-inserted']"), placeholderValidity));
        boolean placeholderCVCField = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//label[@class ='ng-tns-c49-5 ng-star-inserted']"), placeholderCVC));
        boolean placeholderNameUserCardField = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//label[@class ='ng-tns-c49-3 ng-star-inserted']"), placeholderNameUserCard));
        boolean payIcons = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class ='cards-brands cards-brands__container ng-tns-c55-0 ng-trigger ng-trigger-brandsState ng-star-inserted']"))) != null;
    }
}