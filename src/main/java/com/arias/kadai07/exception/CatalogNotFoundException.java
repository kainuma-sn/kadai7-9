package com.arias.kadai07.exception;

public class CatalogNotFoundException extends RuntimeException {
    public CatalogNotFoundException(String message) {
        super(message);
    }
}
