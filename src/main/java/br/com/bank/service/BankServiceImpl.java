package br.com.bank.service;

import java.math.BigDecimal;
import java.util.Optional;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;
import br.com.bank.domain.model.Bank;
import br.com.bank.domain.model.Cards;
import br.com.bank.domain.repository.BankRepository;
import br.com.bank.dto.BankDataTransferObject;
import br.com.bank.dto.BankDataTransferObjectDeposit;
import br.com.bank.service.exception.BankNotFoundException;
import br.com.bank.service.exception.LimitNotAvailableException;
import javassist.NotFoundException;

@Service
public class BankServiceImpl implements BankService {

  private static final Logger LOG = Logger.getLogger(BankServiceImpl.class);

  private BankRepository bankRepository;
  private CardService cardService;

  public BankServiceImpl(BankRepository bankRepository, CardService cardService) {
    this.bankRepository = bankRepository;
    this.cardService = cardService;
  }

  @Override
  public void checkIfThereIsALimitOnTheCardAndDebitTheAvailableAmount(
      BankDataTransferObject bankDTO) {
    try {
      LOG.info("Request receiver, DTO [ " + bankDTO + " ]");
      Bank bank = findBankDatabase(bankDTO);
      accomplishSale(bankDTO, bank);
    } catch (Exception e) {
      LOG.error("error when trying to make the sale, error:  " + e.getMessage(), e);
    }
  }

  private Bank findBankDatabase(BankDataTransferObject bankDTO) throws NotFoundException {
    Cards card = cardService.verifyContainsCard(bankDTO);
    return card.getBank();
  }

  @Override
  public BankDataTransferObjectDeposit depositValueValueInAccount(
      BankDataTransferObjectDeposit bankDTODeposit) {
    LOG.info("Verify bank informed exist...");
    Optional<Bank> bankOptional = bankRepository.findByName(bankDTODeposit.getName())
        .filter(bank -> bankDTODeposit.getAccount().equals(bankDTODeposit.getAccount())
            && bank.getAgency().equals(bankDTODeposit.getAgency()));

    verifyBankNotExist(bankOptional);
    Bank bank = bankOptional.get();

    LOG.info("Depositing amount into your account...");
    bank.setAmountAvailable(bank.getAmountAvailable()
        .add(BigDecimal.valueOf(Double.parseDouble(bankDTODeposit.getAmountDeposit()))));
    bankRepository.saveAndFlush(bank);

    return bankDTODeposit;

  }

  private void accomplishSale(BankDataTransferObject bankDTO, Bank bank)
      throws LimitNotAvailableException, NotFoundException {
    LOG.info("Verify bank informed exist...");

    double amountSale = Double.parseDouble(bankDTO.getAmountSale());

    LOG.info("Amount Sale [ " + amountSale + " ]");

    BigDecimal result =
        bank.getAmountAvailable().subtract(BigDecimal.valueOf(amountSale).setScale(2));

    if (result.doubleValue() >= 0.0) {
      bank.setAmountAvailable(result);
      bankRepository.save(bank);
    } else {
      throw new LimitNotAvailableException("Não existe limite suficiente");
    }
  }

  private void verifyBankNotExist(Optional<Bank> bankOptional) {
    if (!bankOptional.isPresent()) {
      throw new BankNotFoundException("Bank informed not found!");
    }
  }
}
