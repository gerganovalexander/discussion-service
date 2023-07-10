package com.tinqin.academy.discussion.api.errors;

public class GetCommentByIdError extends GenericError{
    public GetCommentByIdError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
