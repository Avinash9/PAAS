package com.payments.accounting.model;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;

/**
 * @author Ankit Thakwani
 * @version $Id: AccountMetadataAttributeConverter.java, v 0.1 2019-10-31 3:03 PM Ankit Thakwani Exp $$
 */

@Component
public class AccountMetadataAttributeConverter implements AttributeConverter<AccountMetadata, String> {

    @Autowired
    private Gson gson;

    @Override
    public String convertToDatabaseColumn(AccountMetadata accountMetadata) {
        return gson.toJson(accountMetadata, AccountMetadata.class);
    }

    @Override
    public AccountMetadata convertToEntityAttribute(String accountMetadataJson) {
        return gson.fromJson(accountMetadataJson, AccountMetadata.class);
    }
}

