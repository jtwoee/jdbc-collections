package com.lc.consultant.jdbc;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class VoucherDimensionGroupRowMapper implements RowMapper<VoucherDimension> {

    @Override
    public VoucherDimension mapRow(ResultSet rs, int i) throws SQLException {
        VoucherDimension vm = new VoucherDimension();


        vm.setVoucherNo(rs.getString("voucher_no"));


//        vm.setSeq(rs.getInt("seq"));
        vm.setCreditAmount(rs.getInt("credit_amount"));
        vm.setDebtAmount(rs.getInt("debt_amount"));
        //for sorting
        vm.setSortByGroup(1);

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


