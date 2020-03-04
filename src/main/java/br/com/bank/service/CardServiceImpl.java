package br.com.bank.service;

import org.springframework.stereotype.Service;
import br.com.bank.convert.Convert;
import br.com.bank.domain.model.Bank;
import br.com.bank.domain.model.Cards;
import br.com.bank.domain.repository.BankRepository;
import br.com.bank.domain.repository.CardsRepository;
import br.com.bank.dto.BankDataTransferObject;
import br.com.bank.dto.CardDataTransferObject;
import br.com.bank.service.exception.CardNotFoundException;
import javassist.NotFoundException;

@Service
public class CardServiceImpl implements CardService {

  private CardsRepository cardRepository;
  private BankRepository bankRepository;

  public CardServiceImpl(CardsRepository cardRepository, BankRepository bankRepository) {
    this.cardRepository = cardRepository;
    this.bankRepository = bankRepository;
  }

  @Override
  public CardDataTransferObject save(CardDataTransferObject cardDTO) {
    Bank bank = bankRepository.findAll().get(0);
    Cards card = Convert.convertToEntity(cardDTO, bank);
    return Convert.convertToDTO(card);
  }

  @Override
  public CardDataTransferObject findByCode(String code) {
    Cards cards = cardRepository.findBySecurityCode(Integer.parseInt(code))
        .orElseThrow(() -> new CardNotFoundException("code informed not found!"));

    CardDataTransferObject cardsDTO = createCardDTO(cards);
    return cardsDTO;
  }


  private CardDataTransferObject createCardDTO(Cards cards) {
    CardDataTransferObject cardsDTO = new CardDataTransferObject();
    cardsDTO.setCardNumber(cards.getCardNumber());
    cardsDTO.setSecurityCode(cards.getSecurityCode().toString());
    cardsDTO.setValidate(cards.getValidate().toString());
    return cardsDTO;
  }

  @Override
  public Cards verifyContainsCard(BankDataTransferObject bankDTO) throws NotFoundException {
    CardDataTransferObject card = bankDTO.getCard();
    Integer securityCode = Integer.parseInt(card.getSecurityCode());
    return cardRepository.findBySecurityCode(securityCode).orElseThrow(() -> new NotFoundException(
        "SecurityCode in Card informed [" + card.getSecurityCode() + "] not found!"));
  }

}
