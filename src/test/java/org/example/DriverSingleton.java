package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSingleton {

    private static WebDriver driver;

    private DriverSingleton() {
    }

    public static ChromeDriver getInstance() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return (ChromeDriver) driver;
    }
}
