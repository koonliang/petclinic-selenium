package org.springframework.samples.petclinic.actions;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.samples.petclinic.interfaces.IUIElements;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

import static java.lang.String.format;
import static org.springframework.samples.petclinic.constants.Constants.UIELEMENT_ERROR_TEXT;

@Slf4j
@Component
public class UIElements extends ActionsBaseClass implements IUIElements {

	@Override
	public void click(By by) {
		utilityClass.scrollHelper(driver, webDriverWait, by);
		driver.findElement(by).click();
		log.debug("Clicked on Link..");

	}

	@Override
	public void sendKeys(By by, String keysToSend) {
		log.info("sendKeys driver = " + driver);
		utilityClass.scrollHelper(driver, webDriverWait, by);
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(keysToSend);
		log.debug("Typed in text : {}", keysToSend);

	}

	@Override
	public void openURL(String url) {
		driver.get(url);

	}

	@Override
	public void clickNestedMenus(By by, String tagName, List<String> menuList) {

		utilityClass.scrollHelper(driver, webDriverWait, by);
		WebElement headerWebElement = driver.findElements(by).stream()
				.filter(element -> element.getText().toLowerCase().contains(menuList.get(0).toLowerCase())).findFirst()
				.orElseThrow(() -> new NoSuchElementException(format(UIELEMENT_ERROR_TEXT, by, menuList.get(0))));
		headerWebElement.click();
		log.debug("Found and clicked on Header Element with Text : {}", menuList.get(0));

		for (int i = 1; i < menuList.size(); i++) {
			String subMenuName = menuList.get(i);
			headerWebElement = headerWebElement.findElements(By.tagName(tagName)).stream()
					.filter(element -> element.getText().toLowerCase().contains(subMenuName.toLowerCase())).findFirst()
					.orElseThrow(() -> new NoSuchElementException(format(UIELEMENT_ERROR_TEXT, by, subMenuName)));
			headerWebElement.click();
			log.debug("Found and clicked on Sub Element with Text : {}", subMenuName);
		}
	}

	@Override
	public String findElementsbyIndex(By by, int index) {
		utilityClass.scrollHelper(driver, webDriverWait, by);
		return driver.findElements(by).get(index).getText();
	}

	@Override
	public void searchAndClickByText(By by, String textForSearch) {
		webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
		driver.findElements(by).stream()
				.filter(element -> element.getText().toLowerCase().contains(textForSearch.toLowerCase())).findFirst()
				.orElseThrow(() -> new NoSuchElementException(format(UIELEMENT_ERROR_TEXT, by, textForSearch))).click();

		log.debug("Found and clicked on Element with Text : {}", textForSearch);

	}

	@Override
	public void clickRelativeLeftElement(By toLeftoOfBy, By withBy) {
		utilityClass.scrollHelper(driver, webDriverWait, withBy);
		driver.findElement(RelativeLocator.with(withBy).toLeftOf(toLeftoOfBy)).click();
		log.debug("Clicked on Link..");

	}

	@Override
	public void searchAndClickRelativeLeftElement(By toLeftoOfBy, By withBy, String textForSearch) {
		webDriverWait.until(ExpectedConditions.elementToBeClickable(toLeftoOfBy));
		driver.findElement(RelativeLocator.with(withBy).toLeftOf(driver.findElements(toLeftoOfBy).stream()
				.filter(element -> element.getText().toLowerCase().contains(textForSearch.toLowerCase())).findFirst()
				.orElseThrow(
						() -> new NoSuchElementException(format(UIELEMENT_ERROR_TEXT, toLeftoOfBy, textForSearch)))))
				.click();

	}

	@Override
	public void searchAndClickTableByText(By by, String textForSearch, String value) {
		webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
		WebElement webElement = driver.findElements(by).stream()
				.flatMap(row -> row.findElements(By.tagName("td")).stream())
				.filter(column -> column.getText().toLowerCase().contains(textForSearch.toLowerCase())).findFirst()
				.orElseThrow(() -> new NoSuchElementException(format(UIELEMENT_ERROR_TEXT, by, textForSearch)));
		driver.findElement(RelativeLocator.with(By.tagName("input")).toRightOf(webElement)).sendKeys(value);

	}

	@Override
	public WebDriver getWebDriver() {
		return driver;
	}
}
