package br.com.bank.service;

import br.com.bank.domain.model.Cards;
import br.com.bank.dto.BankDataTransferObject;
import br.com.bank.dto.CardDataTransferObject;
import javassist.NotFoundException;

public interface CardService {
  CardDataTransferObject findByCode(String code);

  Cards verifyContainsCard(BankDataTransferObject bankDTO) throws NotFoundException;

  CardDataTransferObject save(CardDataTransferObject cardDTO);
}
