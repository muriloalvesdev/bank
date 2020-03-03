package br.com.bank.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.bank.domain.model.Bank;
import br.com.bank.dto.BankDataTransferObject;
import br.com.bank.dto.BankDataTransferObjectDeposit;
import br.com.bank.dto.CardsDataTransferObject;
import br.com.bank.service.BankService;

@RestController
@RequestMapping("api/bank")
public class BankController {

  @Autowired
  private BankService bankService;

  @PostMapping("debit/authorization")
  public ResponseEntity<Bank> debitAuthorization(
      @Valid @RequestBody BankDataTransferObject bankDTO) {
    bankService.checkIfThereIsALimitOnTheCardAndDebitTheAvailableAmount(bankDTO);
    return ResponseEntity.ok().build();
  }

  @PostMapping("deposit")
  public ResponseEntity<Bank> deposit(@RequestBody BankDataTransferObjectDeposit bankDTODeposit) {
    return ResponseEntity.ok(bankService.depositValueValueInAccount(bankDTODeposit));
  }

  @GetMapping("scheduling")
  public ResponseEntity<String> scheduling() {
    return ResponseEntity.ok("OK");
  }

  @GetMapping("find/card/{code}")
  public ResponseEntity<CardsDataTransferObject> findCardByCode(
      @PathVariable(name = "code", required = true) String code) {
    return ResponseEntity.ok(bankService.findByCode(code));
  }

}
