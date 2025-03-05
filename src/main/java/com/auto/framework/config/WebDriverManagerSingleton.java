package com.auto.framework.config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

    public static WebDriver getEdgeDriver() {
        if (driver == null) {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--remote-allow-origins=*");
            //options.addArguments("--headless=new");
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver(options);
        }
        return driver;
    }

    public static WebDriver getChromeDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-debugging-port=9222");
            options.addArguments("--remote-allow-origins=*");
            //options.addArguments("--headless=new");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static WebDriverWait getEdgeDriverWait() {
        return new WebDriverWait(getEdgeDriver(), Duration.of(60, ChronoUnit.SECONDS));
    }

    public static WebDriverWait getChromeDriverWait() {
        return new WebDriverWait(getChromeDriver(), Duration.of(60, ChronoUnit.SECONDS));
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Ensure a fresh instance on next test run
        }
    }
}
