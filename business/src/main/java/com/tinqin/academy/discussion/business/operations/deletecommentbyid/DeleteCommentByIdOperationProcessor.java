package com.tinqin.academy.discussion.business.operations.deletecommentbyid;

import com.tinqin.academy.discussion.api.errors.CreateCommentError;
import com.tinqin.academy.discussion.api.errors.DeleteCommentByIdError;
import com.tinqin.academy.discussion.api.generics.DiscussionError;
import com.tinqin.academy.discussion.api.operations.deletecommentbyid.DeleteCommentByIdInput;
import com.tinqin.academy.discussion.api.operations.deletecommentbyid.DeleteCommentByIdOperation;
import com.tinqin.academy.discussion.api.operations.deletecommentbyid.DeleteCommentByIdResult;
import com.tinqin.academy.discussion.data.models.Comment;
import com.tinqin.academy.discussion.data.repositories.CommentRepository;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCommentByIdOperationProcessor implements DeleteCommentByIdOperation {

    private final CommentRepository commentRepository;

    @Override
    public Either<DiscussionError,DeleteCommentByIdResult> process(final DeleteCommentByIdInput input) {
       return Try.of(() -> {
        Comment comment = commentRepository
                .findById(input.getId())
                .orElseThrow(() ->
                        new EntityNotFoundException(String.format("Comment with id %d not found", input.getId())));

        comment.setMarkedForDelete(true);
        commentRepository.save(comment);

        return DeleteCommentByIdResult.builder().success(true).build();
               })
               .toEither()
               .mapLeft(throwable -> new DeleteCommentByIdError(400, throwable.getMessage()));
    }
}
