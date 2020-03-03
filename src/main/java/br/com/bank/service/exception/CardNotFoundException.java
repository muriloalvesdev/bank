package br.com.bank.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CardNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 7198580117402620298L;

  public CardNotFoundException(String message) {
    super(message);
  }
}
