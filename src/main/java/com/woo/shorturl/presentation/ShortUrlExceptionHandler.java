package com.woo.shorturl.presentation;

import com.woo.shorturl.exception.URLSyntaxException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ShortUrlExceptionHandler {

    @ExceptionHandler({URLSyntaxException.class})
    public ResponseEntity<Object> handleURLException(Exception e) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
