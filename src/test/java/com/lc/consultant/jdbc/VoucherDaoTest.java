package com.lc.consultant.jdbc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

public class VoucherDaoTest {

    private static VoucherDAO voucherDAO;

    private static DataSource dataSource;

    @BeforeClass
    public static void setUp(){
        dataSource = DataSourceBuilder
                .create()
                .driverClassName("com.mysql.jdbc.Driver")
                .url("jdbc:mysql://172.17.162.1:3306/test?serverTimezone=GMT%2B8&useSSL=false")
                .username("root")
                .password("Dev@2019")
                .build();

        voucherDAO = new VoucherDAO();
        voucherDAO.setDataSource(dataSource);
    }


    @Test
    public void whenInjectInMemoryDataSource_thenReturnCorrectVoucherCount() {
//        DataSource dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
//                .addScript("classpath:jdbc/schema.sql")
//                .addScript("classpath:jdbc/test-data.sql")
//                .build();

//        DataSource dataSource = DataSourceBuilder
//                .create()
//                .driverClassName("com.mysql.jdbc.Driver")
//                .url("jdbc:mysql://192.168.134.97:3306/test?serverTimezone=GMT%2B8&useSSL=false")
//                .username("root")
//                .password("Dev@2019")
//                .build();
//
//        VoucherDAO voucherDAO = new VoucherDAO();
//        voucherDAO.setDataSource(dataSource);

        Assert.assertEquals(2, voucherDAO.getCountOfVouchers());
    }

    @Test
    public void shouldReturnCorrectVoucherList(){
        Assert.assertEquals(2, voucherDAO.getVouchers().size());
    }

    @Test
    public void whenGetVoucherDetails() {
        List voucherDetails = voucherDAO.getVoucherDetails();

        System.out.println("voucherDetails = " + voucherDetails);

        Assert.assertEquals(5, voucherDetails.size());
    }

    @Test
    public void whenGetVoucherDetailsWithProjectAccount() {
        List details = voucherDAO.getVoucherDetails();

        System.out.println("voucherDetails = " + details);

        Assert.assertEquals(5, details.size());
    }

}