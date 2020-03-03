package br.com.bank.domain.repository;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.bank.domain.model.Cards;

public interface CardsRepository extends JpaRepository<Cards, UUID> {
  Optional<Cards> findBySecurityCode(Integer securityCode);
}
