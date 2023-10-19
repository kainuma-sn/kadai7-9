package com.arias.kadai07.exception;

public class nullOrEmptyException extends RuntimeException {

    // エラーメッセージを返すコンストラクタ
    public nullOrEmptyException(String message) {
        super(message);
    }
}
