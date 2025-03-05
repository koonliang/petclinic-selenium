package com.auto.framework.config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class WebDriverManagerSingleton {
    private static WebDriver driver;

    private WebDriverManagerSingleton() {
        // Private constructor to prevent direct instantiation
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            driver = new EdgeDriver(options);
        }
        return driver;
    }

    public static WebDriverWait getDriverWait() {
        return new WebDriverWait(getDriver(), Duration.of(60, ChronoUnit.SECONDS));
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Ensure a fresh instance on next test run
        }
    }
}
