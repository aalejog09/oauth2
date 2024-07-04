package com.api.resources.util.exceptions;


import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class APIExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> notValid(MethodArgumentNotValidException ex, HttpServletRequest request) {
        List<String> errors = new ArrayList<>();
        ex.getAllErrors().forEach(err -> errors.add(err.getDefaultMessage()));

        return ResponseEntity.badRequest().body(ErrorDTO.builder()
                .code(APIError.VALIDATION_ERROR.getCode())
                .description(APIError.VALIDATION_ERROR.getHttpStatus().getReasonPhrase())
                .detail(errors)
                .build());
    }

    @ExceptionHandler(APIException.class)
    public ResponseEntity<?> errorTaken(APIException ex, HttpServletRequest request) {
        List<String> errors = new ArrayList<>();
        errors.add(ex.getMessage());
        ex.setReasons(errors);

        return ResponseEntity.status(ex.getHttpStatus())
                .body(ErrorDTO.builder()
                        .code(ex.getCode()).description(ex.getHttpStatus().getReasonPhrase()).detail(ex.getReasons())
                        .build());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> errorTaken(BadRequestException ex, HttpServletRequest request) {
        List<String> errors = new ArrayList<>();
        errors.add(ex.getMessage());

        return ResponseEntity.badRequest()
                .body(ErrorDTO.builder()
                        .code(APIError.VALIDATION_ERROR.getCode())
                        .description(APIError.VALIDATION_ERROR.getHttpStatus().getReasonPhrase())
                        .detail(errors)
                        .build());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handleBadRequestException(MethodArgumentTypeMismatchException ex) {
        List<String> errors = new ArrayList<>();
        log.info("ex: {}",ex.getName());
        errors.add(APIError.ARGUMENT_NOT_VALID.getMessage()+ex.getName());
        errors.add("Value: "+ex.getValue());
        return ResponseEntity.badRequest().body(ErrorDTO.builder()
                .code(APIError.ARGUMENT_NOT_VALID.getCode())
                .description(APIError.ARGUMENT_NOT_VALID.getHttpStatus().getReasonPhrase())
                .detail(errors)
                .build());
    }


}
