package br.com.bank.config;

import java.math.BigDecimal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import br.com.bank.domain.model.Bank;
import br.com.bank.domain.repository.BankRepository;
import br.com.bank.domain.repository.CardsRepository;

@Configuration
public class Config {

  private BankRepository bankRepository;

  public Config(BankRepository bankRepository, CardsRepository cardsRepository) {
    this.bankRepository = bankRepository;
  }

  @Bean
  public void persistBank() {
    if (!bankRepository.findByName("NUBANK").isPresent()) {

      Bank bank = bankRepository.saveAndFlush(
          new Bank("00001", "1234-x", BigDecimal.valueOf(876543456723345L), "NUBANK"));
      bankRepository.saveAndFlush(bank);
    }
  }
}
