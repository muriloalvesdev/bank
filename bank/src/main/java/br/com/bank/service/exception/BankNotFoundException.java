package br.com.bank.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class BankNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1057204788758046775L;

    public BankNotFoundException(String message) {
        super(message);
    }

}
