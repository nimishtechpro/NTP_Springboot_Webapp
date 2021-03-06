package com.np.techpro.service;

import com.np.techpro.dto.AddressDto;
import com.np.techpro.dto.OrganizationDto;
import com.np.techpro.dto.UserDto;
import com.np.techpro.model.Address;
import com.np.techpro.model.Organization;
import com.np.techpro.model.Salary;
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
        List<Address> addressList = new ArrayList<Address>();
            for (AddressDto addressDto: userDto.getAddressList()){
                Address address = new Address();
                address.setAddressLine(addressDto.getAddressLine());
                address.setState(addressDto.getState() );
                address.setZipCode(addressDto.getZipCode());
                addressList.add(address);
            }
        user.setAddressList(addressList);

        List<Organization> organizations = new ArrayList<Organization>();
        for (OrganizationDto organizationDto: userDto.getOrganizationList()){
            Organization organization = new Organization();
            organization.setLocation(organizationDto.getLocation());
            organization.setName(organizationDto.getName());
            organizations.add(organization);
        }

        user.setOrganizations(organizations);
        user.setAddressList(addressList);


        Salary salary = new Salary();
        salary.setAmount(userDto.getSalaryAmount());
        user.setSalary(salary);
        // Save user should save address & salary as well
        User newUser = userRepository.save(user);
        userDto.setUserId(newUser.getUserId());
        return userDto;
    }
}
