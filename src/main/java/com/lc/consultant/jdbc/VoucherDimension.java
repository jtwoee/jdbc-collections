package com.lc.consultant.jdbc;

import java.time.Instant;
import java.util.Objects;

public class VoucherDimension {

    public VoucherDimension() {

    }

    private int id;

    private String voucherNo;

    private String creator;

    private Instant createdDate;

    private int seq;

    private String accountNo;

    private String comments;

    private int creditAmount;

    private int debtAmount;

    private String dimensionType;

    private int sortByGroup = 0;

    public int getSortByGroup() {
        return sortByGroup;
    }

    public void setSortByGroup(int sortByGroup) {
        this.sortByGroup = sortByGroup;
    }



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

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoucherDimension voucher = (VoucherDimension) o;
        return id == voucher.id &&
                Objects.equals(voucherNo, voucher.voucherNo) &&
                Objects.equals(seq, voucher.seq) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, voucherNo, seq);
    }

    @Override
    public String toString() {
        return "VoucherDimension{" +
                "id=" + id +
                ", voucherNo='" + voucherNo + '\'' +
                ", creator='" + creator + '\'' +
                ", createdDate=" + createdDate +
                ", seq=" + seq +
                ", accountNo='" + accountNo + '\'' +
                ", comments='" + comments + '\'' +
                ", creditAmount=" + creditAmount +
                ", debtAmount=" + debtAmount +
                ", dimensionType='" + dimensionType + '\'' +
                ", dimensionCode='" + dimensionCode + '\'' +
                ", dimensionName='" + dimensionName + '\'' +
                '}';
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(int creditAmount) {
        this.creditAmount = creditAmount;
    }

    public int getDebtAmount() {
        return debtAmount;
    }

    public void setDebtAmount(int debtAmount) {
        this.debtAmount = debtAmount;
    }

    public String getDimensionType() {
        return dimensionType;
    }

    public void setDimensionType(String dimensionType) {
        this.dimensionType = dimensionType;
    }

    public String getDimensionCode() {
        return dimensionCode;
    }

    public void setDimensionCode(String dimensionCode) {
        this.dimensionCode = dimensionCode;
    }

    public String getDimensionName() {
        return dimensionName;
    }

    public void setDimensionName(String dimensionName) {
        this.dimensionName = dimensionName;
    }

    private String dimensionCode;

    private String dimensionName;

    public VoucherDetail getVoucherDetail() {
        return new VoucherDetail(voucherNo, seq, creditAmount, debtAmount);
    }

}
