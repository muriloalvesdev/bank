package br.com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.bank.domain.model.Bank;
import br.com.bank.domain.repository.BankRepository;
import br.com.bank.domain.repository.CardsRepository;
import br.com.bank.dto.BankDataTransferObject;
import br.com.bank.dto.BankDataTransferObjectDeposit;
import br.com.bank.service.BankService;

@RestController
@RequestMapping("api/bank")
public class BankController {

  @Autowired
  private BankService bankService;

  @Autowired
  private BankRepository bankRepository;

  @Autowired
  private CardsRepository cardRepository;

  @PostMapping("debit/authorization")
  public ResponseEntity<Bank> debitAuthorization(@RequestBody BankDataTransferObject bankDTO) {
    bankService.checkIfThereIsALimitOnTheCardAndDebitTheAvailableAmount(bankDTO);
    return ResponseEntity.ok().build();
  }

  @PostMapping("deposit")
  public ResponseEntity<Bank> deposit(@RequestBody BankDataTransferObjectDeposit bankDTODeposit) {
    return ResponseEntity.ok(bankService.depositValueValueInAccount(bankDTODeposit));
  }

  @GetMapping("scheduling")
  public ResponseEntity<String> scheduling() {

    bankRepository.deleteAll();
    cardRepository.deleteAll();

    return ResponseEntity.ok("OK");
  }

}
