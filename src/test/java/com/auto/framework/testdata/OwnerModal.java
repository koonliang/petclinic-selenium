package com.auto.framework.testdata;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OwnerModal {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String telephone;
}
