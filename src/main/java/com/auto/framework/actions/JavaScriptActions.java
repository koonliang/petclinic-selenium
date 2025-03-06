package com.auto.framework.actions;

import com.auto.framework.interfaces.IJavaScriptActions;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JavaScriptActions extends ActionsBaseClass implements IJavaScriptActions {

	@Override
	public void scrollIntoView(By by) {
		webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
		log.debug("Test {}", driver.getTitle());
		((JavascriptExecutor) driver)
				.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(by));

		log.debug("Scrolled into View..");
	}

	@Override
	public void click(By by) {
		scrollIntoView(by);
		WebElement element = driver.findElement(by);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				element);

		log.debug("Clicked on Link..");

	}
}
