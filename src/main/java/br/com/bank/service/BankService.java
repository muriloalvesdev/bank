package br.com.bank.service;

import br.com.bank.dto.BankDataTransferObject;
import br.com.bank.dto.BankDataTransferObjectDeposit;
import br.com.bank.resource.BankResource;

public interface BankService {
  void checkIfThereIsALimitOnTheCardAndDebitTheAvailableAmount(BankDataTransferObject bankDTO);

  BankDataTransferObjectDeposit depositValueValueInAccount(
      BankDataTransferObjectDeposit bankDTODeposit);

  String valueAvailable(BankResource bankResource);

}
