package com.example.demo.jwt;

public class LogoutJwtException extends RuntimeException{
    LogoutJwtException() {
    }
    LogoutJwtException(String msg) {
        super(msg);
    }
}
