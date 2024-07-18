package br.com.danilooa.ocpjadee7.webservices.ws;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class WsInput {

    private Integer integer;
    private Byte byte_;
    private Short short_;
    private Long long_;
    private BigDecimal bigDecimal;
    private BigInteger bigInteger;
    private String string;
    private Date date;

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public Byte getByte_() {
        return byte_;
    }

    public void setByte_(Byte byte_) {
        this.byte_ = byte_;
    }

    public Short getShort_() {
        return short_;
    }

    public void setShort_(Short short_) {
        this.short_ = short_;
    }

    public Long getLong_() {
        return long_;
    }

    public void setLong_(Long long_) {
        this.long_ = long_;
    }

    public BigDecimal getBigDecimal() {
        return bigDecimal;
    }

    public void setBigDecimal(BigDecimal bigDecimal) {
        this.bigDecimal = bigDecimal;
    }

    public BigInteger getBigInteger() {
        return bigInteger;
    }

    public void setBigInteger(BigInteger bigInteger) {
        this.bigInteger = bigInteger;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
