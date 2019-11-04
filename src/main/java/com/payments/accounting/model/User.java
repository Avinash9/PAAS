package com.payments.accounting.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

/**
 * @author Ankit Thakwani
 * @version $Id: User.java, v 0.1 2019-10-03 1:16 PM Ankit Thakwani Exp $$
 */

@Entity
@Builder
@AllArgsConstructor
@Data
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NaturalId
    private String firstName;

    private String lastName;

    private String email;

    private Long phoneNumber;

}