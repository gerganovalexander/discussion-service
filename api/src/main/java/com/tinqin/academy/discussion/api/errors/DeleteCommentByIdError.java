package com.tinqin.academy.discussion.api.errors;

public class DeleteCommentByIdError extends GenericError {
    public DeleteCommentByIdError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
