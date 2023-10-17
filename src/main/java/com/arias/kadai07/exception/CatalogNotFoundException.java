package com.arias.kadai07.exception;

//カタログの検索結果がなかった場合、例外をスローする
public class CatalogNotFoundException extends RuntimeException {
    public CatalogNotFoundException(String message) {
        super(message);
    }
}
