package com.auto.framework;

import com.auto.framework.listeners.TestListener;
import com.auto.framework.pageobjects.petclinic.AddOwnerPage;
import com.auto.framework.pageobjects.petclinic.EditOwnerPage;
import com.auto.framework.pageobjects.petclinic.OwnersPage;
import com.auto.framework.pageobjects.petclinic.testdata.OwnerDataProvider;
import com.auto.framework.pageobjects.petclinic.testdata.OwnerModal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
@Listeners(TestListener.class)
public class OwnerTests extends BaseTests {
    @Autowired
    private OwnersPage ownersPage;

    @Autowired
    private EditOwnerPage editOwnerPage;

    @Autowired
    private AddOwnerPage addOwnerPage;

    @Test(priority = 2)
    public void testFindOwner_TC001() {// test find owner function
        // Opens browser page
        ownersPage.openPage();

        // Perform testing actions
        int pageSize = ownersPage.getPageSize();
        logger.debug("pageSize = " + pageSize);

        assertThat(ownersPage.isTablePresent(), is(true));
        assertThat( pageSize >= 0 & pageSize <= 5 , is(true));
    }

    @Test(priority = 3)
    public void testEditOwner_telephoneValidation_TC001() {//test telephone field validation
        // Opens browser page
        editOwnerPage.openPage();

        // Perform testing actions
        editOwnerPage.updateTelephone("91234567");
        editOwnerPage.submitForm();
        assertThat(editOwnerPage.getTelephoneValidationMsg(),is("Telephone must be a 10-digit number"));
    }

    @Test(priority = 4)
    public void testEditOwner_lastNameValidation_TC002() {//test last name field validation
        // Opens browser page
        editOwnerPage.openPage();

        // Perform testing actions
        editOwnerPage.updateLastName("");
        editOwnerPage.submitForm();
        assertThat(editOwnerPage.getLastNameValidationMsg(),is("must not be blank"));
    }

    @Test(priority = 5)
    public void testEditOwner_addressValidation_TC003() {//test address field validation
        // Opens browser page
        editOwnerPage.openPage();

        // Perform testing actions
        editOwnerPage.updateAddress("");
        editOwnerPage.submitForm();
        assertThat(editOwnerPage.getAddressValidationMsg(),is("must not be blank"));
    }

    @Test(priority = 6)
    public void testEditOwner_formSubmit_TC004() {//test form submission success
        // Opens browser page
        editOwnerPage.openPage();

        // Perform testing actions
        editOwnerPage.submitForm();

        assertThat(editOwnerPage.getSuccessMsg(), is("Owner Values Updated"));
    }

    @Test(priority = 10, dataProvider = "Owner Data", dataProviderClass = OwnerDataProvider.class)
    public void testAddOwner_lastNameValidation_TC001(OwnerModal ownerData) {//test last name field validation
        // Opens browser page
        addOwnerPage.openPage();

        // Perform testing actions
        addOwnerPage.updateFormFields(ownerData);
        addOwnerPage.updateLastName("");
        addOwnerPage.submitForm();

        assertThat(addOwnerPage.getLastNameValidationMsg(),is("must not be blank"));
    }

    @Test(priority = 11, dataProvider = "Owner Data", dataProviderClass = OwnerDataProvider.class)
    public void testAddOwner_telephoneValidation_TC002(OwnerModal ownerData) {//test telephone field validation
        // Opens browser page
        addOwnerPage.openPage();

        // Perform testing actions
        addOwnerPage.updateFormFields(ownerData);
        addOwnerPage.updateTelephone("91234567");
        addOwnerPage.submitForm();

        assertThat(addOwnerPage.getTelephoneValidationMsg(),is("Telephone must be a 10-digit number"));
    }

    @Test(priority = 13, dataProvider = "Owner Data", dataProviderClass = OwnerDataProvider.class)
    public void testAddOwner_formSubmit_TC004(OwnerModal ownerData) {//test form submission success
        // Opens browser page
        addOwnerPage.openPage();

        // Perform testing actions
        addOwnerPage.updateFormFields(ownerData);
        addOwnerPage.submitForm();

        assertThat(addOwnerPage.getSuccessMsg(), is("New Owner Created"));
    }
}
