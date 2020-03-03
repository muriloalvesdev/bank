package br.com.bank.service;

import br.com.bank.domain.model.Bank;
import br.com.bank.dto.BankDataTransferObject;
import br.com.bank.dto.BankDataTransferObjectDeposit;

public interface BankService {
  void checkIfThereIsALimitOnTheCardAndDebitTheAvailableAmount(BankDataTransferObject bankDTO);

  Bank depositValueValueInAccount(BankDataTransferObjectDeposit bankDTODeposit);
}
