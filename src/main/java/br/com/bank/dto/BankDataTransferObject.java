package br.com.bank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BankDataTransferObject {

    @JsonProperty("name")
    private String name;

    @JsonProperty("agency")
    private String agency;

    @JsonProperty("account")
    private String account;

    @JsonProperty("amount_sale")
    private String amountSale;

    public String getName() {
        return name;
    }

    public String getAgency() {
        return agency;
    }

    public String getAccount() {
        return account;
    }

    public String getAmountSale() {
        return amountSale;
    }

    @Override
    public String toString() {
        return "BankDataTransferObject [name=" + name + ", agency=" + agency
                + ", account=" + account + ", amountSale=" + amountSale + "]";
    }

}
