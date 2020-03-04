package br.com.bank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BankDataTransferObject {

  @JsonProperty("amount_sale")
  private String amountSale;

  @JsonProperty("card")
  private CardDataTransferObject card;

  public String getAmountSale() {
    return amountSale;
  }

  public CardDataTransferObject getCard() {
    return card;
  }

  public void setCard(CardDataTransferObject card) {
    this.card = card;
  }

  public void setAmountSale(String amountSale) {
    this.amountSale = amountSale;
  }

  @Override
  public String toString() {
    return "BankDataTransferObject [amountSale=" + amountSale + ", card=" + card + "]";
  }

}
