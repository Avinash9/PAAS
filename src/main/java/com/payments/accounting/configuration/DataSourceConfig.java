package com.payments.accounting.configuration;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author Ankit Thakwani
 * @version $Id: DataSourceConfig.java, v 0.1 2019-10-09 10:11 AM Ankit Thakwani Exp $$
 */

@Configuration
@EnableTransactionManagement
public class DataSourceConfig {

    @Bean(name = "accountingTransactionalDataSource")
    public DataSource AccountingDataSource() {

        HikariConfig config = new HikariConfig("/db.properties");
        HikariDataSource ds = new HikariDataSource(config);
        return ds;

    }

}