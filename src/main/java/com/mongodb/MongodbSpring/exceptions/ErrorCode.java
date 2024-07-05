package com.mongodb.MongodbSpring.exceptions;

public enum ErrorCode {
    KEY_INVALID(1001,"Key is invalid"),
    USER_EXISTED(1002,"User existed"),
    UNCATEGORIZED(1003,"Uncategorized"),
    USERNAME_INVALID(1004,"Username is invalid"),
    PASSWORD_INVALID(1005,"Password is invalid"),
    USER_NOT_FOUND(1002,"User not found"),
    UNAUTHENTICATED(1006,"Unauthenticated"),
    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;



    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
