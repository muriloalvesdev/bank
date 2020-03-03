package br.com.bank.dto;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CardsDataTransferObject {

  @JsonProperty("security_code")
  @NotNull
  private String securityCode;

  @JsonProperty("card_holder")
  @NotNull
  private String cardNumber;

  @JsonProperty("validate")
  @JsonFormat(pattern = "dd-MM-yyyy")
  @NotNull
  private String validate;

  public String getSecurityCode() {
    return securityCode;
  }

  public void setSecurityCode(String securityCode) {
    this.securityCode = securityCode;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public String getValidate() {
    return validate;
  }

  public void setValidate(String validate) {
    this.validate = validate;
  }

}
