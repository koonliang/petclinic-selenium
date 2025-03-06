package org.springframework.samples.petclinic.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.config.MyProperties;
import org.springframework.samples.petclinic.config.WebDriverManagerSingleton;
import org.springframework.stereotype.Component;

@Component
public class ActionsBaseClass {

	public static WebDriver driver;
	public static WebDriverWait webDriverWait;

	@Autowired
	public MyProperties myProperties;
	
	@Autowired
	public UtilityClass utilityClass;

	public ActionsBaseClass() {
		this.driver = getDriver();
		this.webDriverWait = getDriverWait();
	}

	protected WebDriver getDriver(){
		return WebDriverManagerSingleton.getEdgeDriver();
	}

	protected WebDriverWait getDriverWait(){
		return WebDriverManagerSingleton.getEdgeDriverWait();
	}

	public void quitDriver() {
		WebDriverManagerSingleton.quitDriver();
	}
}
