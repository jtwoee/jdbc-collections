package com.lc.consultant.jdbc;

import java.util.Date;
import java.util.Objects;

public class Voucher {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voucher voucher = (Voucher) o;
        return id == voucher.id &&
                Objects.equals(voucherNo, voucher.voucherNo) &&
                Objects.equals(creator, voucher.creator) &&
                Objects.equals(createdDate, voucher.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, voucherNo, creator, createdDate);
    }

    public Voucher(int id, String voucherNo, String creator, Date createdDate) {
        this.id = id;
        this.voucherNo = voucherNo;
        this.creator = creator;
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Voucher{" +
                "id=" + id +
                ", voucherNo='" + voucherNo + '\'' +
                ", creator='" + creator + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }

    private int id;

    private String voucherNo;

    private String creator;

    private Date createdDate;

}
