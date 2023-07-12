package com.tinqin.academy.discussion.business.operations.createcomment;

import com.tinqin.academy.discussion.api.errors.CreateCommentError;
import com.tinqin.academy.discussion.api.generics.DiscussionError;
import com.tinqin.academy.discussion.api.operations.createcomment.CreateCommentInput;
import com.tinqin.academy.discussion.api.operations.createcomment.CreateCommentOperation;
import com.tinqin.academy.discussion.api.operations.createcomment.CreateCommentResult;
import com.tinqin.academy.discussion.data.models.Comment;
import com.tinqin.academy.discussion.data.models.EntityType;
import com.tinqin.academy.discussion.data.repositories.CommentRepository;
import com.tinqin.academy.piim.api.game.existsbyid.ExistsByIdGameResult;
import com.tinqin.academy.piim.api.review.existsbyid.ExistsByIdReviewResult;
import com.tinqin.academy.piim.restexport.PiimApiClient;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCommentOperationProcessor implements CreateCommentOperation {

    private final CommentRepository commentRepository;

    private final PiimApiClient piimApiClient;

    @Override
    public Either<DiscussionError, CreateCommentResult> process(CreateCommentInput input) {

        return Try.of(() -> {

                    // Either would fit better
                    switch (input.getEntityType().toLowerCase()) {
                        case "game" -> {
                            ExistsByIdGameResult doesGameExist =
                                    piimApiClient.checkIfGameExistsById(input.getEntityId());
                            if (!doesGameExist.getDoesExist()) {
                                throw new EntityNotFoundException(
                                        String.format("Game with id %d does not exist.", input.getEntityId()));
                            }
                        }
                        case "review" -> {
                            ExistsByIdReviewResult doesReviewExist =
                                    piimApiClient.checkIfReviewExistsById(input.getEntityId());
                            if (!doesReviewExist.getDoesExist()) {
                                throw new EntityNotFoundException(
                                        String.format("Review with id %d does not exist.", input.getEntityId()));
                            }
                        }
                    }
                    Comment comment = Comment.builder()
                            .comment(input.getComment())
                            .userId(input.getUserId())
                            .entityType(EntityType.valueOf(input.getEntityType()))
                            .entityId(input.getEntityId())
                            .build();

                    comment = commentRepository.save(comment);

                    return CreateCommentResult.builder()
                            .id(comment.getId())
                            .comment(comment.getComment())
                            .entityType(String.valueOf(comment.getEntityType()))
                            .entityId(comment.getEntityId())
                            .userId(comment.getUserId())
                            .build();
                })
                .toEither()
                .mapLeft(throwable -> new CreateCommentError(400, throwable.getMessage()));
    }
}
