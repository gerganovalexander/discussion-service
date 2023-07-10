package com.tinqin.academy.discussion.api.generics;

import io.vavr.control.Either;

public interface OperationInterface<I extends OperationInput, R extends OperationResult> {
    Either<DiscussionError,R> process(I input);
}
