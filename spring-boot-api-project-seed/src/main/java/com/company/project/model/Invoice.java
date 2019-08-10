package com.company.project.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

public class Invoice {
    @Column(name = "invoice_id")
    private Integer invoiceId;

    @Column(name = "invoice_date")
    private Date invoiceDate;

    @Column(name = "billing_address")
    private String billingAddress;

    @Column(name = "billing_city")
    private String billingCity;

    @Column(name = "billing_state")
    private Integer billingState;

    @Column(name = "billing_country")
    private String billingCountry;

    @Column(name = "billing_postalCode")
    private String billingPostalcode;

    private BigDecimal total;

    @Column(name = "customer_id")
    private Integer customerId;

    /**
     * @return invoice_id
     */
    public Integer getInvoiceId() {
        return invoiceId;
    }

    /**
     * @param invoiceId
     */
    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    /**
     * @return invoice_date
     */
    public Date getInvoiceDate() {
        return invoiceDate;
    }

    /**
     * @param invoiceDate
     */
    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    /**
     * @return billing_address
     */
    public String getBillingAddress() {
        return billingAddress;
    }

    /**
     * @param billingAddress
     */
    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    /**
     * @return billing_city
     */
    public String getBillingCity() {
        return billingCity;
    }

    /**
     * @param billingCity
     */
    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    /**
     * @return billing_state
     */
    public Integer getBillingState() {
        return billingState;
    }

    /**
     * @param billingState
     */
    public void setBillingState(Integer billingState) {
        this.billingState = billingState;
    }

    /**
     * @return billing_country
     */
    public String getBillingCountry() {
        return billingCountry;
    }

    /**
     * @param billingCountry
     */
    public void setBillingCountry(String billingCountry) {
        this.billingCountry = billingCountry;
    }

    /**
     * @return billing_postalCode
     */
    public String getBillingPostalcode() {
        return billingPostalcode;
    }

    /**
     * @param billingPostalcode
     */
    public void setBillingPostalcode(String billingPostalcode) {
        this.billingPostalcode = billingPostalcode;
    }

    /**
     * @return total
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * @param total
     */
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    /**
     * @return customer_id
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}