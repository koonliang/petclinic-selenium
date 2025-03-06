package com.auto.framework.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@Component
public class UtilityClass {

	public void scrollHelper(WebDriver driver, WebDriverWait webDriverWait, By by) {
		webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
		((JavascriptExecutor) driver)
				.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(by));
	}

}
