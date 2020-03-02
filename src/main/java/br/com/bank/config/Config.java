package br.com.bank.config;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import br.com.bank.domain.model.Bank;
import br.com.bank.domain.repository.BankRepository;

@Configuration
public class Config {

  @Autowired
  private BankRepository repository;

  @Bean
  public void persistBank() {
    if (!repository.findByName("NUBANK").isPresent()) {
      repository.saveAndFlush(
          new Bank("00001", "1234-x", BigDecimal.valueOf(876543456723345L), "NUBANK"));
    }
  }
}
