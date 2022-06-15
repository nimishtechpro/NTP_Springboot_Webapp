package com.np.techpro.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private Long userId;
    private String firstName;
    private String lastName;
    private List<AddressDto> addressList;
}
