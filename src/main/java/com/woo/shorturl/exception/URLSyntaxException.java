package com.woo.shorturl.exception;

public class URLSyntaxException extends RuntimeException {
    public URLSyntaxException(String message, Throwable cause) {
        super(message, cause);
    }
}
