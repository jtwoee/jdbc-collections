package com.lc.consultant.jdbc;

import java.time.Instant;
import java.util.Objects;

public class VoucherDetail {

    public VoucherDetail() {

    }

    public VoucherDetail(String voucherNo, int seq, int creditAmount, int debtAmount) {
        this.voucherNo = voucherNo;
        this.seq = seq;
        this.creditAmount = creditAmount;
        this.debtAmount = debtAmount;
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
        VoucherDetail that = (VoucherDetail) o;
        return seq == that.seq &&
                voucherNo.equals(that.voucherNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(voucherNo, seq);
    }

    public VoucherDetail(int id, String voucherNo, String creator, Instant createdDate) {
        this.id = id;
        this.voucherNo = voucherNo;
        this.creator = creator;
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "VoucherDetail{" +
                "id=" + id +
                ", voucherNo='" + voucherNo + '\'' +
                ", seq=" + seq +
                ", creditAmount=" + creditAmount +
                ", debtAmount=" + debtAmount +
                '}';
    }

    private int id;

    private String voucherNo;

    private String creator;

    private Instant createdDate;

    private int seq;

    public int getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(int creditAmount) {
        this.creditAmount = creditAmount;
    }

    private int creditAmount;

    private int debtAmount;

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }
}
