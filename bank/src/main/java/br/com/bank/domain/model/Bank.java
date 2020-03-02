package br.com.bank.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "bank", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "account" }) })
public class Bank extends BaseEntity {

    private static final long serialVersionUID = 1689419762198758933L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    @Column(name = "name")
    private String name;

    @Column(name = "agency")
    private String agency;

    @Column(name = "account")
    private String account;

    @Column(name = "amount_available")
    private BigDecimal amountAvailable;

    @SuppressWarnings("unused")
    private Bank() {
    }

    public Bank(String agency, String account, BigDecimal amountAvailable,
            String name) {
        this.agency = agency;
        this.account = account;
        this.amountAvailable = amountAvailable;
        this.name = name;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public BigDecimal getAmountAvailable() {
        return amountAvailable;
    }

    public void setAmountAvailable(BigDecimal amountAvailable) {
        this.amountAvailable = amountAvailable;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
