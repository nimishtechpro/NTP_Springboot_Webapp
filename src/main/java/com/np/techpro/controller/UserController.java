package com.np.techpro.controller;

import com.np.techpro.dto.User;
import com.np.techpro.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @PostMapping("/users")
    public Long addNewUser(@RequestBody User user){
        com.np.techpro.model.User enitityUser = new com.np.techpro.model.User();
        enitityUser.setFirstName(user.getFirstName());
        enitityUser.setLastName(user.getLastName());
        com.np.techpro.model.User result= userRepository.save(enitityUser);
        return result.getId();
    }
    @GetMapping("users/list")
    public User getAllUsers(){
        User user = new User();
        user.setFirstName("nimish");
        user.setLastName("pp");
        return user;
    }
}
