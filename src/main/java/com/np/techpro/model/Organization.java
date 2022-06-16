package com.np.techpro.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Data
public class Organization {
    @Id
    @GeneratedValue
    private Long organizationId;
    private String name;
    private String location;

    @ManyToMany(mappedBy ="organizations")
    private List<User> users;
}
