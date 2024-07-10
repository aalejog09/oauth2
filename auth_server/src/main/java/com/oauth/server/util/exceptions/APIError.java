package com.oauth.server.util.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

@Getter
public enum APIError {

    VALIDATION_ERROR("E0001",HttpStatus.BAD_REQUEST, "The are attributes with wrong values", Collections.emptyList()),
    TOKEN_EXPIRED("E0002", HttpStatus.BAD_REQUEST, "Error Token Expired", List.of("")),
    MISSING_REQUEST_BODY("E0003",HttpStatus.BAD_REQUEST, "Required request body is missing", Collections.emptyList()),
    ARGUMENT_NOT_VALID("E0004", HttpStatus.BAD_REQUEST, "Input value not supported for field: ", List.of("")),
    NOT_FOUND("E0005", HttpStatus.NOT_FOUND, "The requested information does not exist", List.of(""))
    ;

    private final String code;
    private final String message;
    private final HttpStatus httpStatus;
    private final List<String> reasons;

    APIError(String code, HttpStatus httpStatus, String message, List<String> reasons) {
        this.code = code;
        this.message = message;
        this.reasons = reasons;
        this.httpStatus = httpStatus;
    }

}

