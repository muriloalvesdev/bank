package br.com.bank.config;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import br.com.bank.domain.model.Bank;
import br.com.bank.domain.model.Cards;
import br.com.bank.domain.repository.BankRepository;
import br.com.bank.domain.repository.CardsRepository;

@Configuration
public class Config {

  @Autowired
  private BankRepository bankRepository;

  @Autowired
  private CardsRepository cardsRepository;

  @Bean
  public void persistBank() {
    if (!bankRepository.findByName("NUBANK").isPresent()) {
      Bank bank = bankRepository.saveAndFlush(
          new Bank("00001", "1234-x", BigDecimal.valueOf(876543456723345L), "NUBANK"));

      cardsRepository.deleteAll();
      cardsRepository
          .saveAndFlush(new Cards(789, "9999888877776666", LocalDate.parse("01-01-2100"), bank));
    }
  }
}
