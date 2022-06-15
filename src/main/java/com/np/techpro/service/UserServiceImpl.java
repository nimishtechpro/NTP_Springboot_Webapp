package com.np.techpro.service;

import com.np.techpro.dto.UserDto;
import com.np.techpro.model.Address;
import com.np.techpro.model.User;
import com.np.techpro.repository.AddressRepository;
import com.np.techpro.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());


        Address address = new Address();
        address.setAddressLine(userDto.getAddressLine());
        address.setState(userDto.getState());
        address.setZipCode(userDto.getZipCode());

        List<Address> addressList = new ArrayList<Address>();
        addressList.add(address);
        user.setAddressList(addressList);

        User newUser = userRepository.save(user);
      //  addressRepository.save(address);
        userDto.setUserId(newUser.getId());
        userDto.setAddressId(newUser.getId());
        return userDto;
    }
}
