package com.arias.kadai07.exception;

public class CatalogDataAccessException extends RuntimeException {
    // エラーとメッセージを返すコンストラクタ
    public CatalogDataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
