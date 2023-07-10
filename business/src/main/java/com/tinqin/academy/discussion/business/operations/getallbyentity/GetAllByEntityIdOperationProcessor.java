package com.tinqin.academy.discussion.business.operations.getallbyentity;

import com.tinqin.academy.discussion.api.errors.CreateCommentError;
import com.tinqin.academy.discussion.api.errors.GetAllByEntityIdError;
import com.tinqin.academy.discussion.api.generics.DiscussionError;
import com.tinqin.academy.discussion.api.operations.getallbyentityid.GetAllByEntityIdInput;
import com.tinqin.academy.discussion.api.operations.getallbyentityid.GetAllByEntityIdOperation;
import com.tinqin.academy.discussion.api.operations.getallbyentityid.GetAllByEntityIdResult;
import com.tinqin.academy.discussion.data.models.Comment;
import com.tinqin.academy.discussion.data.models.EntityType;
import com.tinqin.academy.discussion.data.repositories.CommentRepository;
import entityoutputmodels.CommentOutput;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAllByEntityIdOperationProcessor implements GetAllByEntityIdOperation {

    private final CommentRepository commentRepository;

    @Override
    public Either<DiscussionError, GetAllByEntityIdResult> process(GetAllByEntityIdInput input) {
        return Try.of(() -> {
                    EntityType entityType =
                            EntityType.valueOf(input.getEntityType().toUpperCase());

                    Pageable pageable = PageRequest.of(input.getPage(), input.getLimit());
                    Page<Comment> comments =
                            commentRepository.findAllByEntityIdAndEntityType(input.getEntityId(), entityType, pageable);

                    return GetAllByEntityIdResult.builder()
                            .page(comments.getNumber())
                            .limit(comments.getSize())
                            .totalItems(comments.getTotalElements())
                            .commentOutput(comments.stream()
                                    .map(comment -> CommentOutput.builder()
                                            .id(comment.getId())
                                            .userId(comment.getUserId())
                                            .comment(comment.getComment())
                                            .build())
                                    .toList())
                            .build();
                })
                .toEither()
                .mapLeft(throwable -> new GetAllByEntityIdError(400, throwable.getMessage()));
    }
}
