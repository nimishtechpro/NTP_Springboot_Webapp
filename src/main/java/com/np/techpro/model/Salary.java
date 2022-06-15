package com.np.techpro.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
public class Salary {
    @Id
    @GeneratedValue
    private Long salaryId;
    private Long amount;
   @OneToOne(mappedBy = "salary")
    private User user;
}
