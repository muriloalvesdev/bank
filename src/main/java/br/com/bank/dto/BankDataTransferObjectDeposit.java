package br.com.bank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BankDataTransferObjectDeposit {
  @JsonProperty("name")
  private String name;

  @JsonProperty("agency")
  private String agency;

  @JsonProperty("account")
  private String account;

  @JsonProperty("amount_deposit")
  private String amountDeposit;

  public String getName() {
    return name;
  }

  public void setName(String name) {
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

  public String getAmountDeposit() {
    return amountDeposit;
  }

  public void setAmountDeposit(String amountDeposit) {
    this.amountDeposit = amountDeposit;
  }

}
