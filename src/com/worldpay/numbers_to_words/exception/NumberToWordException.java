package com.worldpay.numbers_to_words.exception;

public class NumberToWordException extends RuntimeException {

    public NumberToWordException() {
        super();
    }

    public NumberToWordException(String exceptionCode) {
        super(exceptionCode);
    }
}
