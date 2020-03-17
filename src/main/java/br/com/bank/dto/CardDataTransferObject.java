package br.com.bank.dto;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import br.com.bank.resource.BankResource;

public class CardDataTransferObject {

  @JsonProperty("security_code")
  @NotNull(message = "security_code is required!")
  private String securityCode;

  @JsonProperty("card_number")
  @NotNull(message = "card_number is required!")
  private String cardNumber;

  @JsonProperty("validate")
  @JsonFormat(pattern = "yyyy-MM-dd")
  @NotNull(message = "validate is required!")
  private String validate;

  @JsonProperty("bank_owner")
  @NotNull(message = "bank_owner is required!")
  private BankResource bankResource;

  public CardDataTransferObject(@NotNull String securityCode, @NotNull String cardNumber,
      @NotNull String validate) {
    this.securityCode = securityCode;
    this.cardNumber = cardNumber;
    this.validate = validate;
  }

  public CardDataTransferObject() {}

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

  @Override
  public String toString() {
    return "CardDataTransferObject [securityCode=" + securityCode + ", cardNumber=" + cardNumber
        + ", validate=" + validate + "]";
  }

}
