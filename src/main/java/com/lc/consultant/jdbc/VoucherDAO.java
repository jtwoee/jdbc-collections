package com.lc.consultant.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Collections;
import java.util.List;

public class VoucherDAO extends BaseDAO{

    public List getVouchers(){

        return Collections.emptyList();
    }

    public int getCountOfVouchers() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM voucher", Integer.class);
    }

    public List<Voucher> getEmployees() {
//        String inSql = String.join(",", Collections.nCopies(ids.size(), "?"));
        String inSql = "SELECT * FROM EMPLOYEE";
        List<Voucher> vouchers = jdbcTemplate.query(inSql,
                new Object[]{},
                (rs, rowNum) -> new Voucher(rs.getInt("id"),
                        rs.getString("voucher_no"),
                        rs.getString("creator"),
                        rs.getDate("created_date")));

        return vouchers;
    }
}
