package com.payments.accounting.model;

import com.payments.accounting.model.request.enums.Tenant;
import com.payments.accounting.model.request.enums.AccountStatus;
import com.payments.accounting.model.request.enums.AccountType;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Ankit Thakwani
 * @version $Id: Account.java, v 0.1 2019-10-30 2:36 PM Ankit Thakwani Exp $$
 */

@Entity
@Data
@Table(name="account")
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Basic(optional = false)
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Tenant tenant;

    @Basic(optional = false)
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Basic(optional = false)
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    @Basic(optional = false)
    private String ownerId;

    @Basic(optional = false)
    @Convert(converter = AccountMetadataAttributeConverter.class)
    private AccountMetadata accountMetadata;

    @Version
    private long version;

    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTimestamp;

    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTimestamp;

}