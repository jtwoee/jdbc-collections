package com.lc.consultant.jdbc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.util.Collections;

public class VoucherDaoTest {


    @Test
    public void whenInjectInMemoryDataSource_thenReturnCorrectVoucherCount() {
        DataSource dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:jdbc/schema.sql")
                .addScript("classpath:jdbc/test-data.sql")
                .build();

        dataSource = DataSourceBuilder
                .create()
                .driverClassName("com.mysql.jdbc.Driver")
                .url("jdbc:mysql://192.168.134.97:3306/test?serverTimezone=GMT%2B8&useSSL=false")
                .username("root")
                .password("Dev@2019")
                .build();

        VoucherDAO voucherDAO = new VoucherDAO();
        voucherDAO.setDataSource(dataSource);

        Assert.assertEquals(1, voucherDAO.getCountOfVouchers());
    }
}