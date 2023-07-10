package com.tinqin.academy.discussion.api.errors;

public class DeleteAllByEntityIdError extends GenericError {
    public DeleteAllByEntityIdError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
