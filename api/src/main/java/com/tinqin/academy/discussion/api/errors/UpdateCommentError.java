package com.tinqin.academy.discussion.api.errors;

public class UpdateCommentError extends GenericError {
    public UpdateCommentError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
