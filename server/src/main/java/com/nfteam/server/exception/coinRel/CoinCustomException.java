package com.nfteam.server.exception.coinRel;

import com.nfteam.server.exception.ExceptionCode;

public class CoinCustomException extends RuntimeException {
    private final ExceptionCode exceptionCode;

    public CoinCustomException(ExceptionCode exceptionCode, String message) {
        super(message);
        this.exceptionCode = exceptionCode;
    }
}
