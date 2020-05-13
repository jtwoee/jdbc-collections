package com.lc.consultant.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

public class VoucherDAO extends BaseDAO{


    public int getCountOfVouchers() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM voucher", Integer.class);
    }

    public List<Voucher> getVouchers() {
//        String inSql = String.join(",", Collections.nCopies(ids.size(), "?"));
        String inSql = "SELECT * FROM voucher";
//        List<Voucher> vouchers = jdbcTemplate.query(inSql,
//                new Object[]{},
//                (rs, rowNum) ->
////                        LocalDate.pa
//                        new Voucher(rs.getInt("id"),
//                        rs.getString("voucher_no"),
//                        rs.getString("creator"),
//                        rs.getString("created_date")));

        List vouchers = jdbcTemplate.query(inSql,
                new Object[]{},
                new VoucherRowMapper());

        return vouchers;
    }

    public List getVoucherDetails(){

        String sql = "SELECT header.voucher_no, header.creator, header.created_date,\n" +
                "detail.seq, detail.account_no, detail.comments,detail.credit_amount, detail.debt_amount\n" +
                " FROM voucher header\n" +
                "inner join voucher_detail detail\n" +
                "on header.voucher_no = detail.voucher_no";

        List voucherDetails = jdbcTemplate.queryForList(sql);

        return voucherDetails;
    }

    public List getVoucherDetailsWithProjectAccount(){

        String sql = "SELECT header.voucher_no, header.creator, header.created_date,\n" +
                "detail.seq, detail.account_no, detail.comments,detail.credit_amount, detail.debt_amount,\n" +
                "project.dimension_type, project.dimension_code, project.dimension_name\n" +
                " FROM voucher header\n" +
                "inner join voucher_detail detail\n" +
                "on header.voucher_no = detail.voucher_no\n" +
                "left join project_account project\n" +
                "on detail.voucher_no = project.voucher_no and detail.seq = project.seq";

        List list = jdbcTemplate.queryForList(sql);

        return list;
    }

}
