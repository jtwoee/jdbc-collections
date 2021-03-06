package com.lc.consultant.jdbc;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class VoucherDimensionRowMapper implements RowMapper<VoucherDimension> {

    @Override
    public VoucherDimension mapRow(ResultSet rs, int i) throws SQLException {
        VoucherDimension vm = new VoucherDimension();

        vm.setId(rs.getInt("id"));
        vm.setVoucherNo(rs.getString("voucher_no"));
        vm.setCreator(rs.getString("creator"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        Instant createdDate = LocalDate.parse(rs.getString("created_date"), formatter)
                .atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant();
        vm.setCreatedDate(createdDate);

        vm.setSeq(rs.getInt("seq"));
        vm.setAccountNo(rs.getString("account_no"));
        vm.setComments(rs.getString("comments"));
        vm.setCreditAmount(rs.getInt("credit_amount"));
        vm.setDebtAmount(rs.getInt("debt_amount"));
        vm.setDimensionType(rs.getString("dimension_type"));
        vm.setDimensionCode(rs.getString("dimension_code"));
        vm.setDimensionName(rs.getString("dimension_name"));

        return vm;
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


