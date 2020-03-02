package br.com.bank.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bank.domain.model.Bank;
import br.com.bank.domain.repository.BankRepository;
import br.com.bank.dto.BankDataTransferObject;
import br.com.bank.dto.BankDataTransferObjectDeposit;
import br.com.bank.service.exception.BankNotFoundException;
import br.com.bank.service.exception.LimitNotAvailableException;

@Service
public class BankServiceImpl implements BankService {

    private static final Logger LOG = Logger.getLogger(BankServiceImpl.class);

    @Autowired
    private BankRepository bankRepository;

    @Override
    public void checkIfThereIsALimitOnTheCardAndDebitTheAvailableAmount(
            BankDataTransferObject bankDTO) {
        LOG.info("Request receiver, DTO [ " + bankDTO + " ]");
        Optional<Bank> bankOptional = findBankDatabase(bankDTO);
        accomplishSale(bankDTO, bankOptional);
    }

    private Optional<Bank> findBankDatabase(BankDataTransferObject bankDTO) {
        return bankRepository.findByName(bankDTO.getName())
                .filter(bank -> bank.getAccount().equals(bankDTO.getAccount())
                        && bank.getAgency().equals(bankDTO.getAgency()));
    }

    @Override
    public Bank save(BankDataTransferObject bankDTO) {
        return bankRepository.save(new Bank(bankDTO.getAgency(),
                bankDTO.getAccount(),
                BigDecimal.valueOf(Double.parseDouble(bankDTO.getAmountSale()))
                        .setScale(2),
                bankDTO.getName()));
    }

    @Override
    public Bank depositValueValueInAccount(
            BankDataTransferObjectDeposit bankDTODeposit) {
        LOG.info("Verify bank informed exist...");
        Optional<Bank> bankOptional = bankRepository
                .findByName(bankDTODeposit.getName())
                .filter(bank -> bankDTODeposit.getAccount()
                        .equals(bankDTODeposit.getAccount())
                        && bank.getAgency().equals(bankDTODeposit.getAgency()));

        verifyBankNotExist(bankOptional);
        Bank bank = bankOptional.get();

        LOG.info("Depositing amount into your account...");
        bank.setAmountAvailable(
                bank.getAmountAvailable().add(BigDecimal.valueOf(Double
                        .parseDouble(bankDTODeposit.getAmountDeposit()))));
        return bankRepository.save(bank);

    }

    private void accomplishSale(BankDataTransferObject bankDTO,
            Optional<Bank> bankOptional) throws LimitNotAvailableException {
        LOG.info("Verify bank informed exist...");
        verifyBankNotExist(bankOptional);

        Bank bank = bankOptional.get();
        double amountSale = Double.parseDouble(bankDTO.getAmountSale());

        LOG.info("Amount Sale [ " + amountSale + " ]");
        LOG.info("Debiting sale amount at customer card limit [ Agency: [ "
                + bankDTO.getAgency() + " ], Account: [ " + bankDTO.getAccount()
                + " ], Bank: [ " + bank.getName() + " ]");

        BigDecimal result = bank.getAmountAvailable()
                .subtract(BigDecimal.valueOf(amountSale).setScale(2));

        if (result.doubleValue() >= 0.0) {
            bank.setAmountAvailable(result);
            bankRepository.save(bank);
        } else {
            throw new LimitNotAvailableException(
                    "Não existe limite suficiente");
        }
    }

    private void verifyBankNotExist(Optional<Bank> bankOptional) {
        if (!bankOptional.isPresent()) {
            throw new BankNotFoundException("Bank informed not found!");
        }
    }

}
