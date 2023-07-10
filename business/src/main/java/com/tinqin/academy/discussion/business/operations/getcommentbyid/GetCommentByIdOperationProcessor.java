package com.tinqin.academy.discussion.business.operations.getcommentbyid;

import com.tinqin.academy.discussion.api.errors.CreateCommentError;
import com.tinqin.academy.discussion.api.errors.GetCommentByIdError;
import com.tinqin.academy.discussion.api.generics.DiscussionError;
import com.tinqin.academy.discussion.api.operations.getcommentbyid.GetCommentByIdInput;
import com.tinqin.academy.discussion.api.operations.getcommentbyid.GetCommentByIdOperation;
import com.tinqin.academy.discussion.api.operations.getcommentbyid.GetCommentByIdResult;
import com.tinqin.academy.discussion.data.models.Comment;
import com.tinqin.academy.discussion.data.repositories.CommentRepository;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetCommentByIdOperationProcessor implements GetCommentByIdOperation {

    private final CommentRepository commentRepository;

    @Override
    public Either<DiscussionError, GetCommentByIdResult> process(final GetCommentByIdInput input) {
        return Try.of(() -> {
                    Comment comment = commentRepository
                            .findById(input.getId())
                            .orElseThrow(() -> new EntityNotFoundException(
                                    String.format("Comment with id %d not found", input.getId())));

                    return GetCommentByIdResult.builder()
                            .id(comment.getId())
                            .comment(comment.getComment())
                            .userId(comment.getUserId())
                            .build();
                })
                .toEither()
                .mapLeft(throwable -> new GetCommentByIdError(400, throwable.getMessage()));
    }
}
