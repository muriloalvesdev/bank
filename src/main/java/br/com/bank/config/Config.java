package br.com.bank.config;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import br.com.bank.domain.model.Bank;
import br.com.bank.domain.model.Cards;
import br.com.bank.domain.repository.BankRepository;
import br.com.bank.domain.repository.CardsRepository;

@Configuration
public class Config {

  private BankRepository bankRepository;
  private CardsRepository cardsRepository;

  public Config(BankRepository bankRepository, CardsRepository cardsRepository) {
    this.bankRepository = bankRepository;
    this.cardsRepository = cardsRepository;
  }

  @Bean
  public void persistBank() {
    System.out.println("bean persist iniciado");

    if (!bankRepository.findByName("NUBANK").isPresent()) {
      System.out.println("banco nao existe, persistindo na base");

      Bank bank = bankRepository.saveAndFlush(
          new Bank("00001", "1234-x", BigDecimal.valueOf(876543456723345L), "NUBANK"));


      System.out.println("banco salvo na base, nome: " + bank.getName());


      Cards card = new Cards(789, "9999888877776666", LocalDate.parse("01-01-2100"), bank);

      System.out.println("salvando cartao no banco: " + card.getSecurityCode());
      cardsRepository.saveAndFlush(card);

      System.out.println("cartao salvo, uuid: " + card.getUuid());
      bank.setCard(card);
      bankRepository.saveAndFlush(bank);
    }
  }
}
