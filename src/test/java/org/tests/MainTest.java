package org.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class MainTest extends BaseTest {

    // Проверка названия блока оплаты.
    @Test(priority = 1)
    public static void checkLogoText() throws InterruptedException {
        WebElement blockText = driver.findElement(By.xpath("//section[@class='pay']/div/h2"));
        String expectedText = "Онлайн пополнение\nбез комиссии";
        Assert.assertEquals(blockText.getText(), expectedText);
    }

    // Проверка наличия логотипов платёжных систем.
    @Test(priority = 2)
    public static void checkLogosPartners() throws InterruptedException {
        List<WebElement> payPartnersLogos = driver.findElements(By.xpath("//div[@class='pay__partners']"));
        Assert.assertFalse(payPartnersLogos.isEmpty());
    }

    // Проверка работы ссылки «Подробнее о сервисе»
    @Test(priority = 3)
    public static void checkLink() throws InterruptedException {
        WebElement linkAboutService = driver.findElement(By.xpath("//section[@class='pay']/div/a"));
        linkAboutService.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("poryadok-oplaty-i-bezopasnost-internet-platezhey"));
    }

    // Проверка полей и работы кнопки «Продолжить»
    @Test(priority = 4)
    public static void checkFieldsAndButtonContinue() throws InterruptedException {
        WebElement communicationServicesField = driver.findElement(By.xpath("//*[@id='pay']"));
        WebElement phoneField = driver.findElement(By.xpath("//*[@id = 'connection-phone']"));
        WebElement amountField = driver.findElement(By.xpath("//*[@id = 'connection-sum']"));
        WebElement buttonContinue = driver.findElement(By.xpath("//*[@id ='pay-connection']/button"));

        Select communicationServicesFieldSelect = new Select(communicationServicesField);
        communicationServicesFieldSelect.selectByVisibleText("Услуги связи");
        phoneField.sendKeys("297777777");
        amountField.sendKeys("65");
        buttonContinue.click();

        WebElement iframe = driver.findElement(By.xpath("//iframe[@class = 'bepaid-iframe']"));
        driver.switchTo().frame(iframe);
        // Assert.assertTrue(driver.findElement(By.xpath("//*[@Class='app-wrapper']")).isDisplayed());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean isPopupVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='app-wrapper']"))) != null;
    }

    //****************************************************************************************************************************************************

    //LESSON 14:

    @Test(priority = 5) // Проверка  надписи в поле "Номер телефона" варианта оплаты "Услуги связи".
    public static void checkTextPhoneFieldCommunicationServices() throws InterruptedException {
        WebElement communicationServicesField = driver.findElement(By.xpath("//select[@id='pay']"));
        WebElement phoneFieldCS = driver.findElement(By.xpath("//input[@id = 'connection-phone']"));
        String actualPlaceholderPhoneFieldCS = phoneFieldCS.getAttribute("placeholder");

        Select communicationServicesFieldSelect = new Select(communicationServicesField);
        communicationServicesFieldSelect.selectByVisibleText("Услуги связи");
        String expectedPlaceholderPhoneFieldCS = "Номер телефона";
        Assert.assertEquals(actualPlaceholderPhoneFieldCS, expectedPlaceholderPhoneFieldCS);
    }

    @Test(priority = 6) // Проверка  надписи в поле "Сумма" варианта оплаты "Услуги связи".
    public static void checkTextAmountFieldCommunicationServices() throws InterruptedException {
        WebElement amountFieldCS = driver.findElement(By.xpath("//input[@id = 'connection-sum']"));
        String actualPlaceholderAmountFieldCS = amountFieldCS.getAttribute("placeholder");
        String expectedPlaceholderAmountFieldCS = "Сумма";
        Assert.assertEquals(actualPlaceholderAmountFieldCS, expectedPlaceholderAmountFieldCS);
    }

    @Test(priority = 7) // Проверка  надписи в поле "E-mail для отправки чека" варианта оплаты "Услуги связи".
    public static void checkTextEmailFieldCommunicationServices() throws InterruptedException {
        WebElement emailFieldCS = driver.findElement(By.xpath("//input[@id = 'connection-email']"));
        String actualPlaceholderEmailFieldCS = emailFieldCS.getAttribute("placeholder");
        String expectedPlaceholderEmailFieldCS = "E-mail для отправки чека";
        Assert.assertEquals(actualPlaceholderEmailFieldCS, expectedPlaceholderEmailFieldCS);
    }

    @Test(priority = 8)  // Проверка  надписи в поле варианта оплаты "Домашний интернет".
    public static void checkTextFieldHomeInternet() throws InterruptedException {
        WebElement listOfServicesField = driver.findElement(By.xpath("//div[@class ='select__wrapper']"));
        listOfServicesField.click();
        WebElement choiceHomeInternet = driver.findElement(By.xpath("//li[@class ='select__item']/p[text() = \"Домашний интернет\"]"));
        choiceHomeInternet.click();
        String expectedTextFieldHomeInternet = "Домашний интернет";
        Assert.assertEquals(choiceHomeInternet.getText(), expectedTextFieldHomeInternet);
    }

    @Test(priority = 9) // Проверка  надписи в поле "Номер телефона" варианта оплаты "Домашний интернет".
    public static void checkTextPhoneFieldHomeInternet() throws InterruptedException {
        WebElement listOfServicesField = driver.findElement(By.xpath("//div[@class ='select__wrapper']"));
        listOfServicesField.click();
        WebElement choiceHomeInternet = driver.findElement(By.xpath("//li[@class ='select__item']/p[text() = \"Домашний интернет\"]"));
        choiceHomeInternet.click();
        WebElement phoneFieldInt = driver.findElement(By.xpath("//input[@id = 'internet-phone']"));
        String actualPlaceholderPhoneFieldInt = phoneFieldInt.getAttribute("placeholder");
        String expectedPlaceholderPhoneFieldInt = "Номер абонента";
        Assert.assertEquals(actualPlaceholderPhoneFieldInt, expectedPlaceholderPhoneFieldInt);
    }

    @Test(priority = 10) // Проверка  надписи в поле "Сумма" варианта оплаты "Домашний интернет".
    public static void checkTextAmountFieldHomeInternet() throws InterruptedException {
        WebElement listOfServicesField = driver.findElement(By.xpath("//div[@class ='select__wrapper']"));
        listOfServicesField.click();
        WebElement choiceHomeInternet = driver.findElement(By.xpath("//li[@class ='select__item']/p[text() = \"Домашний интернет\"]"));
        choiceHomeInternet.click();
        WebElement amountFieldInt = driver.findElement(By.xpath("//input[@id = 'internet-sum']"));
        String actualPlaceholderAmountFieldInt = amountFieldInt.getAttribute("placeholder");
        String expectedPlaceholderAmountFieldInt = "Сумма";
        Assert.assertEquals(actualPlaceholderAmountFieldInt, expectedPlaceholderAmountFieldInt);
    }

    @Test(priority = 11) // Проверка  надписи в поле "E-mail для отправки чека" варианта оплаты "Домашний интернет".
    public static void checkTextEmailFieldHomeInternet() throws InterruptedException {
        WebElement listOfServicesField = driver.findElement(By.xpath("//div[@class ='select__wrapper']"));
        listOfServicesField.click();
        WebElement choiceHomeInternet = driver.findElement(By.xpath("//li[@class ='select__item']/p[text() = \"Домашний интернет\"]"));
        choiceHomeInternet.click();
        WebElement emailFieldInt = driver.findElement(By.xpath("//input[@id = 'internet-email']"));
        String actualPlaceholderEmailFieldInt = emailFieldInt.getAttribute("placeholder");
        String expectedPlaceholderEmailFieldInt = "E-mail для отправки чека";
        Assert.assertEquals(actualPlaceholderEmailFieldInt, expectedPlaceholderEmailFieldInt);
    }


    @Test(priority = 12) // Проверка  надписи в поле варианта оплаты "Рассрочка".
    public static void checkTextFieldInstallmentPlan() throws InterruptedException {
        WebElement listOfServicesField = driver.findElement(By.xpath("//div[@class ='select__wrapper']"));
        listOfServicesField.click();
        WebElement choiceInstallmentPlan = driver.findElement(By.xpath("//li[@class ='select__item']/p[text() = \"Рассрочка\"]"));
        choiceInstallmentPlan.click();
        String expectedTextFieldInstallmentPlan = "Рассрочка";
        Assert.assertEquals(choiceInstallmentPlan.getText(), expectedTextFieldInstallmentPlan);
    }

    @Test(priority = 13) // Проверка  надписи в поле "Номер счета на 44" варианта оплаты "Рассрочка".
    public static void checkTextAccNumberFieldInstallmentPlan() throws InterruptedException {
        WebElement listOfServicesField = driver.findElement(By.xpath("//div[@class ='select__wrapper']"));
        listOfServicesField.click();
        WebElement choiceInstallmentPlan = driver.findElement(By.xpath("//li[@class ='select__item']/p[text() = \"Рассрочка\"]"));
        choiceInstallmentPlan.click();
        WebElement accNumberFieldInst = driver.findElement(By.xpath("//input[@id =\"score-instalment\"]"));
        String actualPlaceholderAccNumberInst = accNumberFieldInst.getAttribute("placeholder");
        String expectedPlaceholderAccNumberInst = "Номер счета на 44";
        Assert.assertEquals(actualPlaceholderAccNumberInst, expectedPlaceholderAccNumberInst);
    }

    @Test(priority = 14) // Проверка  надписи в поле "Сумма" варианта оплаты "Рассрочка".
    public static void checkTextAmountFieldInstallmentPlan() throws InterruptedException {
        WebElement listOfServicesField = driver.findElement(By.xpath("//div[@class ='select__wrapper']"));
        listOfServicesField.click();
        WebElement choiceInstallmentPlan = driver.findElement(By.xpath("//li[@class ='select__item']/p[text() = \"Рассрочка\"]"));
        choiceInstallmentPlan.click();
        WebElement amountFieldInst = driver.findElement(By.xpath("//input[@id =\"instalment-sum\"]"));
        String actualPlaceholderAmountFieldInst = amountFieldInst.getAttribute("placeholder");
        String expectedPlaceholderAmountFieldInst = "Сумма";
        Assert.assertEquals(actualPlaceholderAmountFieldInst, expectedPlaceholderAmountFieldInst);
    }

    @Test(priority = 15) // Проверка  надписи в поле "E-mail для отправки чека" варианта оплаты "Рассрочка".
    public static void checkTextEmailFieldInstallmentPlan() throws InterruptedException {
        WebElement listOfServicesField = driver.findElement(By.xpath("//div[@class ='select__wrapper']"));
        listOfServicesField.click();
        WebElement choiceInstallmentPlan = driver.findElement(By.xpath("//li[@class ='select__item']/p[text() = \"Рассрочка\"]"));
        choiceInstallmentPlan.click();
        WebElement emailFieldInst = driver.findElement(By.xpath("//input[@id =\"instalment-email\"]"));
        String actualPlaceholderEmailFieldInst = emailFieldInst.getAttribute("placeholder");
        String expectedPlaceholderEmailFieldInst = "E-mail для отправки чека";
        Assert.assertEquals(actualPlaceholderEmailFieldInst, expectedPlaceholderEmailFieldInst);
    }

    @Test(priority = 16) // Проверка  надписи в поле варианта оплаты "Задолженность".
    public static void checkTextFieldDebt() throws InterruptedException {
        WebElement listOfServicesField = driver.findElement(By.xpath("//div[@class ='select__wrapper']"));
        listOfServicesField.click();
        WebElement choiceDebt = driver.findElement(By.xpath("//li[@class ='select__item']/p[text() = \"Задолженность\"]"));
        choiceDebt.click();
        String expectedTextFieldDebt = "Задолженность";
        Assert.assertEquals(choiceDebt.getText(), expectedTextFieldDebt);
    }

    @Test(priority = 17) // Проверка  надписи в поле "Номер счета на 2073" варианта оплаты "Задолженность".
    public static void checkTextAccNumberFieldDebt() throws InterruptedException {
        WebElement listOfServicesField = driver.findElement(By.xpath("//div[@class ='select__wrapper']"));
        listOfServicesField.click();
        WebElement choiceDebt = driver.findElement(By.xpath("//li[@class ='select__item']/p[text() = \"Задолженность\"]"));
        choiceDebt.click();
        WebElement accNumberFieldDebt = driver.findElement(By.xpath("//input[@id = \"score-arrears\"]"));
        String actualPlaceholderAccNumberDebt = accNumberFieldDebt.getAttribute("placeholder");
        String expectedPlaceholderAccNumberDebt = "Номер счета на 2073";
        Assert.assertEquals(actualPlaceholderAccNumberDebt, expectedPlaceholderAccNumberDebt);
    }

    @Test(priority = 18) // Проверка  надписи в поле "Сумма" варианта оплаты "Задолженность".
    public static void checkTextAmountFieldDebt() throws InterruptedException {
        WebElement listOfServicesField = driver.findElement(By.xpath("//div[@class ='select__wrapper']"));
        listOfServicesField.click();
        WebElement choiceDebt = driver.findElement(By.xpath("//li[@class ='select__item']/p[text() = \"Задолженность\"]"));
        choiceDebt.click();
        WebElement amountFieldDebt = driver.findElement(By.xpath("//input[@id = \"arrears-sum\"]"));
        String actualPlaceholderAmountFieldDebt = amountFieldDebt.getAttribute("placeholder");
        String expectedPlaceholderAmountFieldDebt = "Сумма";
        Assert.assertEquals(actualPlaceholderAmountFieldDebt, expectedPlaceholderAmountFieldDebt);
    }

    @Test(priority = 19) // Проверка  надписи в поле "Email" варианта оплаты "Задолженность".
    public static void checkTextEmailFieldDebt() throws InterruptedException {
        WebElement listOfServicesField = driver.findElement(By.xpath("//div[@class ='select__wrapper']"));
        listOfServicesField.click();
        WebElement choiceDebt = driver.findElement(By.xpath("//li[@class ='select__item']/p[text() = \"Задолженность\"]"));
        choiceDebt.click();
        WebElement emailFieldDebt = driver.findElement(By.xpath("//input[@id = \"arrears-email\"]"));
        String actualPlaceholderEmailFieldDebt = emailFieldDebt.getAttribute("placeholder");
        String expectedPlaceholderEmailFieldDebt = "E-mail для отправки чека";
        Assert.assertEquals(actualPlaceholderEmailFieldDebt, expectedPlaceholderEmailFieldDebt);
    }

    @Test(priority = 20) // Проверка корректности отображения суммы в хеддере Popup
    public static void checkCorrectAmountPopup() throws InterruptedException {
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        boolean checkAmountPopup = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class = 'header__payment-amount']/span"), valueAmount));
    }

    @Test(priority = 21) // Проверка корректности отображения номера телефона в Popup
    public static void checkCorrectPhonePopup() throws InterruptedException {
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        boolean checkNumberPhone = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//p[@class = 'header__payment-info']"), valueNumberPhone));
    }

    @Test(priority = 22) // Проверка корректности отображения суммы на кнопке в Popup
    public static void checkCorrectAmountButtonPopup() throws InterruptedException {
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        boolean checkTextButtonOfPay = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//button[text() = ' Оплатить  65.00 BYN ']"), valueAmount));
    }

    @Test(priority = 23) // Проверка корректности отображения placeholder в поле для ввода номера карты
    public static void checkTextFieldNumberCardPopup() throws InterruptedException {
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        String placeholderCardNumber = "Номер карты";
        boolean placeholderCardNumberField = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//label[@class= 'ng-tns-c49-1 ng-star-inserted']"), placeholderCardNumber));
    }

    @Test(priority = 24) // Проверка корректности отображения placeholder в поле для ввода срока действия карты
    public static void checkTextFieldValidityCardPopup() throws InterruptedException {
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        String placeholderValidity = "Срок действия";
        boolean placeholderValidityField = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//label[@class ='ng-tns-c49-4 ng-star-inserted']"), placeholderValidity));
    }

    @Test(priority = 25) // Проверка корректности отображения placeholder в поле для ввода CVC карты
    public static void checkTextFieldCVCCardPopup() throws InterruptedException {
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        String placeholderCVC = "CVC";
        boolean placeholderCVCField = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//label[@class ='ng-tns-c49-5 ng-star-inserted']"), placeholderCVC));
    }

    @Test(priority = 26) // Проверка корректности отображения placeholder в поле для ввода имени держателя карты
    public static void checkTextFieldNameUserCardPopup() throws InterruptedException {
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        String placeholderNameUserCard = "Имя держателя (как на карте)";
        boolean placeholderNameUserCardField = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//label[@class ='ng-tns-c49-3 ng-star-inserted']"), placeholderNameUserCard));
    }

    @Test(priority = 27) // Проверка наличия иконок платёжных систем
    public static void checkPayIconsPopup() throws InterruptedException {
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        boolean payIcons = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class ='cards-brands cards-brands__container ng-tns-c55-0 ng-trigger ng-trigger-brandsState ng-star-inserted']"))) != null;

        //проверка корректности отображения суммы
        /*WebElement actualAmountPopup = driver.findElement(By.xpath("//span[contains(text(), 'BYN')]"));
        Assert.assertTrue(actualAmountPopup.getText().contains(valueAmount));

        //проверка корректности отображения телефона
        WebElement actualNumberPhone = driver.findElement(By.xpath("//p[@class = 'header__payment-info']"));
        Assert.assertTrue(actualNumberPhone.getText().contains(valueNumberPhone));

        //проверка корректности отображения суммы на кнопке
        WebElement buttonOfPay = driver.findElement(By.xpath("//button[@class = 'colored disabled ng-star-inserted']/text()"));
        String expectedTextButtonOfPay = " Оплатить  65.00 BYN ";
        Assert.assertEquals(buttonOfPay.getText(), expectedTextButtonOfPay);

        // проверка надписей в незаполненных полях для ввода реквизитов карты

        WebElement cardNumberField = driver.findElement(By.xpath("//label[@class=\"ng-tns-c49-1 ng-star-inserted\"]"));
        Assert.assertTrue(cardNumberField.getText().contains("Номер карты"));

        WebElement validityField = driver.findElement(By.xpath("//label[@class ='ng-tns-c49-4 ng-star-inserted']"));
        Assert.assertTrue(validityField.getText().contains("Срок действия"));

        WebElement cvcCodeField = driver.findElement(By.xpath("//label[@class ='ng-tns-c49-5 ng-star-inserted']"));
        String cvcExp = "CVC";
        Assert.assertEquals(cvcCodeField.getText(), cvcExp);

        WebElement nameUserCardField = driver.findElement(By.xpath("//label[@class ='ng-tns-c49-3 ng-star-inserted']"));
        String nameUserCard = "Имя держателя (как на карте)";
        Assert.assertEquals(nameUserCardField.getText(), nameUserCard);*/
    }
}