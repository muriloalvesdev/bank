package br.com.bank.domain.model;

import java.time.LocalDate;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "cards", uniqueConstraints = {@UniqueConstraint(columnNames = {"security_code"})})
public class Cards extends BaseEntity {

  private static final long serialVersionUID = -1053993242101447545L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID uuid;

  @Column(name = "security_code")
  private Integer securityCode;

  @Column(name = "card_number")
  private String cardNumber;

  @Column(name = "validate")
  @DateTimeFormat(pattern = "dd-MM-yyyy")
  private LocalDate validate;

  @OneToOne(optional = false)
  private Bank bank;

  @SuppressWarnings("unused")
  private Cards() {}

  public Cards(Integer securityCode, String cardNumber, LocalDate validate, Bank bank) {
    this.securityCode = securityCode;
    this.cardNumber = cardNumber;
    this.validate = validate;
    this.bank = bank;
  }

  public Integer getSecurityCode() {
    return securityCode;
  }

  public void setSecurityCode(Integer securityCode) {
    this.securityCode = securityCode;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public LocalDate getValidate() {
    return validate;
  }

  public void setValidate(LocalDate validate) {
    this.validate = validate;
  }

  public Bank getBank() {
    return bank;
  }

  public void setBank(Bank bank) {
    this.bank = bank;
  }

  public UUID getUuid() {
    return uuid;
  }

}
