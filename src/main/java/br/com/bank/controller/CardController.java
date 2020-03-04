package br.com.bank.controller;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.bank.dto.CardDataTransferObject;
import br.com.bank.service.CardService;

@RestController
@RequestMapping("api/card")
public class CardController {

  @Autowired
  private CardService service;

  @GetMapping("find/{code}")
  public ResponseEntity<CardDataTransferObject> findCardByCode(
      @PathVariable(name = "code", required = true) String code) {
    return ResponseEntity.ok(service.findByCode(code));
  }

  @PostMapping("save")
  public ResponseEntity<CardDataTransferObject> save(CardDataTransferObject cardDTO) {
    return ResponseEntity.created(URI.create("find/" + cardDTO.getSecurityCode()))
        .body(service.save(cardDTO));
  }

}
