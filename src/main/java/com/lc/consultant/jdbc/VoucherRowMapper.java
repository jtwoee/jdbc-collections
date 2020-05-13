package com.lc.consultant.jdbc;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class VoucherRowMapper implements RowMapper<Voucher> {

    @Override
    public Voucher mapRow(ResultSet rs, int i) throws SQLException {
        Voucher voucher = new Voucher();

        voucher.setId(rs.getInt("id"));
        voucher.setVoucherNo(rs.getString("voucher_no"));
        voucher.setCreator(rs.getString("creator"));
//        voucher.setCreatedDate();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        Instant createdDate = LocalDate.parse(rs.getString("created_date"), formatter)
                .atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant();
        voucher.setCreatedDate(createdDate);

        return voucher;
    }

//    @Override
//    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
//        Employee employee = new Employee();
//
//        employee.setId(rs.getInt("ID"));
//        employee.setFirstName(rs.getString("FIRST_NAME"));
//        employee.setLastName(rs.getString("LAST_NAME"));
//        employee.setAddress(rs.getString("ADDRESS"));
//
//        return employee;
//    }

}


