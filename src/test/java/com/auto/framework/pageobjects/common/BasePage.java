package com.auto.framework.pageobjects.common;

import com.auto.framework.actions.ActionsBaseClass;
import com.auto.framework.config.WebDriverManagerSingleton;
import com.auto.framework.interfaces.IElementVerification;
import com.auto.framework.interfaces.IExplicitWait;
import com.auto.framework.interfaces.IJavaScriptActions;
import com.auto.framework.interfaces.IUIElements;
import io.qameta.allure.Attachment;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static java.util.Objects.nonNull;
@Slf4j
@Component
public class BasePage extends ActionsBaseClass {

	@Autowired
	public IUIElements iUIElements;

	@Autowired
	public IElementVerification iElementVerification;

	@Autowired
	public IExplicitWait iExplicitWait;

	@Autowired
	public IJavaScriptActions iJavaScriptActions;

	public boolean isWebDriverActive() {
		if (driver == null) return false;

		try {
			driver.getWindowHandles(); // This will throw an exception if the driver is closed
			return true;  // WebDriver is still active
		} catch (WebDriverException e) {
			return false; // WebDriver has quit
		}
	}

	public void refreshDriver(){
		driver = WebDriverManagerSingleton.getDriver();
		webDriverWait = WebDriverManagerSingleton.getDriverWait();
	}

	public void teardownDriver() {
		log.info("Taking Screenshots");
		attachScreenShot();
		log.info("Closing Browsers");
		quitDriver();
	}

	@Attachment(value = "Screen shot", type = "image/png", fileExtension = ".png")
	public byte[] attachScreenShot() {
		try {
			return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		} catch (WebDriverException e) {
			log.error("Selenium screenshot capture failed: {}", e.getMessage());
		}
		return new byte[0];
	}

}
