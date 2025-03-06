package org.springframework.samples.petclinic.pageobjects;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.springframework.samples.petclinic.pageobjects.common.BasePage;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.samples.petclinic.constants.Constants.OWNERS_PAGE;

@Component
@AllArgsConstructor
public class OwnersPage extends BasePage {

    public void openPage(){
        iUIElements.openURL(myProperties.getDemoUrl() + OWNERS_PAGE);
    }

    @Step("Test if web table is present")
    public boolean isTablePresent(){
        try {
            iUIElements.getWebDriver().findElement(By.id("owners"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Test what is the page size of the web table")
    public int getPageSize(){
        List<WebElement> elements = iUIElements.getWebDriver().findElements(By.xpath("//*[@id=\"owners\"]//a"));
        if (elements != null & elements.size() > 0){
            return elements.size();
        }
        return 0;
    }

}
