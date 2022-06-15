package com.np.techpro.dto;

import lombok.Data;

@Data
public class AddressDto {

    private Long addressId;
    private String addressLine;
    private String state;
    private String zipCode;
}
