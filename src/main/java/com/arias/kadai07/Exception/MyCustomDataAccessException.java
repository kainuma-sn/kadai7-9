package com.arias.kadai07.Exception;

public class MyCustomDataAccessException extends RuntimeException {
    //コンストラクタ
    public MyCustomDataAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyCustomDataAccessException(String message) {
        super(message);
    }
}
