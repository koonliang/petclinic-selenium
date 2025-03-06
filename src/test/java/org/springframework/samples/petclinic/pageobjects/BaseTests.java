package org.springframework.samples.petclinic.pageobjects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.pageobjects.common.BasePage;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class BaseTests extends AbstractTestNGSpringContextTests {

    @Autowired
    private BasePage basePage;
    @BeforeMethod
    @Override
    public void springTestContextPrepareTestInstance() throws Exception {
        super.springTestContextPrepareTestInstance();

        if (!basePage.isWebDriverActive()){
            basePage.refreshDriver();
        }
    }

    @AfterSuite
    public void teardownDriver() {
        basePage.teardownDriver();
    }

    @AfterMethod
    public void takeScreenshot() {
        basePage.attachScreenShot();
    }
}
