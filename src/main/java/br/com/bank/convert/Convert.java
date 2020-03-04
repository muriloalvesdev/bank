package br.com.bank.convert;

import java.time.LocalDate;
import br.com.bank.domain.model.Bank;
import br.com.bank.domain.model.Cards;
import br.com.bank.dto.CardDataTransferObject;

public final class Convert {

  private Convert() {}

  public static final Cards convertToEntity(CardDataTransferObject cardDTO, Bank bank) {
    return new Cards(Integer.parseInt(cardDTO.getSecurityCode()), cardDTO.getCardNumber(),
        LocalDate.parse(cardDTO.getValidate()), bank);
  }

  public static final CardDataTransferObject convertToDTO(Cards card) {
    return new CardDataTransferObject(card.getSecurityCode().toString(), card.getCardNumber(),
        card.getValidate().toString());
  }
}
