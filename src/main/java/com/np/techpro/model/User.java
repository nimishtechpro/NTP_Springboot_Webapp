package com.np.techpro.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    private Long userId;

    private String firstName;
    private String lastName;


    @OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL)
    //name - user-address foreign key
    @JoinColumn(name = "user_address_fk", referencedColumnName = "userId")
    private List<Address> addressList;

    // owning side and reference side
    @OneToOne(targetEntity = Salary.class, cascade = CascadeType.ALL)
    //name - user-salary foreign key
    @JoinColumn(name = "user_salary_fk", referencedColumnName = "salaryId")
    private Salary salary;

    // TODO Note : Faced the below error , when cascade configuration missed to provide initially.
    //object references an unsaved transient instance - save the transient instance before flushing:
    @ManyToMany(targetEntity = Organization.class, cascade = CascadeType.ALL)
    @JoinTable(name="user_organization", joinColumns=@JoinColumn(name="userId")
    , inverseJoinColumns = @JoinColumn(name ="organizationId"))
    private List<Organization> organizations;

    /*
    ==========================================================
    Run the following queries to see the results in h2 console
    ==========================================================
    select * from organization
    select * from salary
    select * from user
    select * from user_organization
    ==========================================================
     */

}
