package br.com.bank.domain.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bank.domain.model.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, UUID> {
  Optional<Bank> findByName(String name);
}
