package com.example.demo.app.domain.exception.exceptions;

import com.example.demo.app.domain.model.dto.error.ErrorCode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContractFailureException extends RuntimeException {
    private final ErrorCode errorCode;

    public ContractFailureException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        log.trace(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}