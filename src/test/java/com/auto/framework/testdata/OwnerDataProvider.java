package com.auto.framework.testdata;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;
import org.testng.annotations.DataProvider;

@Component
public class OwnerDataProvider {
    @DataProvider(name = "Owner Data", parallel = true)
    public Object[][] ownerDataProvider() {
        Object[][] ownerData =  {{generateOwnerData()}};
        return ownerData;
    }

    public OwnerModal generateOwnerData(){
        Faker faker = new Faker();

        return OwnerModal.builder().firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .address(faker.address().fullAddress())
                .city(faker.country().capital())
                .telephone(faker.number().digits(10))
                .build();

    }
}
