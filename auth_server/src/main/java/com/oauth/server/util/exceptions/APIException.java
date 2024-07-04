package com.oauth.server.util.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Setter
@Getter
public class APIException extends RuntimeException {

    private String code;
    private final HttpStatus httpStatus;
    private List<String> reasons;

    public APIException(APIError apiError) {
        super(apiError.getMessage());
        this.code= apiError.getCode();
        this.httpStatus = apiError.getHttpStatus();
        this.reasons = apiError.getReasons();
    }

}
