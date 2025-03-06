package org.springframework.samples.petclinic.pageobjects;

import io.qameta.allure.Step;
import org.springframework.samples.petclinic.pageobjects.common.BasePage;
import org.springframework.stereotype.Component;

@Component
public class MainPage extends BasePage {
    @Step("Open webpage")
    public void openPage() {
        iUIElements.openURL(myProperties.getDemoUrl());
    }

    @Step("Verify Page Title")
    public String getPageTitle() {
        return iElementVerification.getTitle();
    }
}
