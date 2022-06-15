package com.np.techpro.controller;

import com.np.techpro.dto.UserDto;
import com.np.techpro.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public UserDto addNewUser(@RequestBody UserDto user){

       UserDto userDto = userService.createUser(user);
        return userDto;
    }
    @GetMapping("users/list")
    public UserDto getAllUsers(){
        UserDto user = new UserDto();
        user.setFirstName("nimish");
        user.setLastName("pp");
        return user;
    }
}
