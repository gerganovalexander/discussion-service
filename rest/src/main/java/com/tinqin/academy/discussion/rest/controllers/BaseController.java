package com.tinqin.academy.discussion.rest.controllers;

import com.tinqin.academy.discussion.api.generics.DiscussionError;
import io.vavr.control.Either;
import org.springframework.http.ResponseEntity;

public abstract class BaseController {

    protected ResponseEntity<?> handleOperation(final Either<DiscussionError, ?> result) {
        if (result.isLeft()) {
            return ResponseEntity.status(result.getLeft().getStatusCode()).body(result.getLeft());
        }
        return ResponseEntity.status(200).body(result.get());
    }
}
