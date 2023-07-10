package com.tinqin.academy.discussion.api.errors;

public class GetAllByEntityIdError extends GenericError {
    public GetAllByEntityIdError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
