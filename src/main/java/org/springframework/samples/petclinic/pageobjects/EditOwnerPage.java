package org.springframework.samples.petclinic.pageobjects;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.springframework.samples.petclinic.pageobjects.common.BasePage;
import org.springframework.stereotype.Component;

import static org.springframework.samples.petclinic.constants.Constants.OWNERS_PAGE;

@Component
@AllArgsConstructor
public class EditOwnerPage extends BasePage {
    private static By firstNameTextField = By.id("firstName");
    private static By lastNameTextField = By.id("lastName");
    private static By addressTextField = By.id("address");
    private static By cityTextField = By.id("city");
    private static By telephoneTextField = By.id("telephone");
    private static By updateBtn = By.cssSelector(".btn");

    private static By lastNameValidationMsg = By.xpath("//*[@id=\"add-owner-form\"]/div[1]/div[2]/div/span[2]");
    private static By telephoneValidationMsg = By.xpath("//*[@id=\"add-owner-form\"]/div[1]/div[5]/div/span[2]");
    private static By addressValdiationMsg = By.xpath("//*[@id=\"add-owner-form\"]/div[1]/div[3]/div/span[2]");
    private static By successMsg = By.id("success-message");

    public void openPage(){
        iUIElements.openURL(myProperties.getDemoUrl() + OWNERS_PAGE + "/1/edit");
    }

    @Step("Update telephone field")
    public void updateTelephone(String telephone){
        iUIElements.getWebDriver().findElement(telephoneTextField).clear();
        iUIElements.sendKeys(telephoneTextField, telephone);
    }

    @Step("Update last name field")
    public void updateLastName(String lastName){
        iUIElements.getWebDriver().findElement(lastNameTextField).clear();
        iUIElements.sendKeys(lastNameTextField, lastName);
    }

    @Step("Update address field")
    public void updateAddress(String address){
        iUIElements.getWebDriver().findElement(addressTextField).clear();
        iUIElements.sendKeys(addressTextField, address);
    }

    @Step("Submit form to update owner")
    public void submitForm(){
        iUIElements.click(updateBtn);
    }

    @Step("Last name validation")
    public String getLastNameValidationMsg(){
        return iElementVerification.getText(lastNameValidationMsg);
    }

    @Step("Address validation")
    public String getAddressValidationMsg(){
        return iElementVerification.getText(addressValdiationMsg);
    }

    @Step("Telephone validation")
    public String getTelephoneValidationMsg(){
        return iElementVerification.getText(telephoneValidationMsg);
    }

    @Step("Success message")
    public String getSuccessMsg(){
        return iElementVerification.getText(successMsg);
    }
}
