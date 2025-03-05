package com.auto.framework.actions;

import com.auto.framework.config.MyProperties;
import com.auto.framework.config.WebDriverManagerSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Component
public class ActionsBaseClass {

	public static WebDriver driver;
	public static WebDriverWait webDriverWait;

	@Autowired
	public MyProperties myProperties;
	
	@Autowired
	public UtilityClass utilityClass;

	public ActionsBaseClass() {
		this.driver = WebDriverManagerSingleton.getDriver();
		this.webDriverWait = WebDriverManagerSingleton.getDriverWait();
	}

	public void quitDriver() {
		WebDriverManagerSingleton.quitDriver();
	}
}
