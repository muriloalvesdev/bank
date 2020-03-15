package br.com.bank.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class LimitNotAvailableException extends RuntimeException {

  private static final long serialVersionUID = -4126215176840743512L;

  public LimitNotAvailableException(String message) {
    super(message);
  }

}
