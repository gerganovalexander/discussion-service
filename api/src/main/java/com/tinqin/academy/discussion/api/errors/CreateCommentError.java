package com.tinqin.academy.discussion.api.errors;

public class CreateCommentError extends GenericError {
    public CreateCommentError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
