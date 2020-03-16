package br.com.bank.resource;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BankResource {

  @JsonProperty("account")
  @NotNull(message = "account is required!")
  private String account;

  @JsonProperty("agency")
  @NotNull(message = "agency is required!")
  private String agency;

  @JsonProperty("bank_name")
  @NotNull(message = "bank_name is required!")
  private String bankName;

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public String getAgency() {
    return agency;
  }

  public void setAgency(String agency) {
    this.agency = agency;
  }

  public String getBankName() {
    return bankName;
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }
}
