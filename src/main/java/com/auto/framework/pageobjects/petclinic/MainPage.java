package com.auto.framework.pageobjects.petclinic;

import com.auto.framework.pageobjects.common.BasePage;
import io.qameta.allure.Step;
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
