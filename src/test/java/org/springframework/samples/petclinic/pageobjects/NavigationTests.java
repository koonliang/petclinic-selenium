package org.springframework.samples.petclinic.pageobjects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.petclinic.listeners.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
@Listeners(TestListener.class)
public class NavigationTests extends BaseTests  {


    @Autowired
    private MainPage mainPage;

    @Test(priority = 1, groups = "Landing Page")
    public void testLandingPage() {
        mainPage.openPage();

        assertThat(mainPage.getPageTitle(), is("PetClinic :: a Spring Framework demonstration"));
    }
}
