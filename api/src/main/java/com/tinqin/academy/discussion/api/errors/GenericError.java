package com.tinqin.academy.discussion.api.errors;

import com.tinqin.academy.discussion.api.generics.DiscussionError;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class GenericError implements DiscussionError {

    private final Integer statusCode;
    private final String message;
}
