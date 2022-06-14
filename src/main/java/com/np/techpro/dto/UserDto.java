package com.np.techpro.dto;

import lombok.Data;

@Data
public class UserDto {

    private Long userId;
    private Long addressId;
    private String firstName;
    private String lastName;
    private String addressLine;
    private String state;
    private String zipCode;
}
