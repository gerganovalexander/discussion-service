package com.tinqin.academy.discussion.business.operations.createcomment;

import com.tinqin.academy.discussion.data.models.Comment;
import com.tinqin.academy.discussion.data.models.EntityType;
import com.tinqin.academy.discussion.data.repositories.CommentRepository;
import com.tinqin.academy.piim.api.game.existsbyid.ExistsByIdGameResult;
import com.tinqin.academy.piim.api.game.getbyid.GetByIdGameResult;
import com.tinqin.academy.piim.api.review.existsbyid.ExistsByIdReviewResult;
import com.tinqin.academy.piim.api.review.getbyid.GetByIdReviewResult;
import com.tinqin.academy.piim.restexport.PiimApiClient;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import operations.createcomment.CreateCommentInput;
import operations.createcomment.CreateCommentOperation;
import operations.createcomment.CreateCommentResult;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreateCommentOperationProcessor implements CreateCommentOperation {

    private final CommentRepository commentRepository;

    private final PiimApiClient piimApiClient;

    @Override
    public CreateCommentResult process(CreateCommentInput input) {

        // Either would fit better
        switch (input.getEntityType().toLowerCase()) {
            case "game":
                ExistsByIdGameResult doesGameExist = piimApiClient.checkIfGameExistsById(input.getEntityId());
                if (!doesGameExist.getDoesExist()) {
                    throw new EntityNotFoundException(
                            String.format("Game with id %d does not exist.", input.getEntityId()));
                }
            case "review":
                ExistsByIdReviewResult doesReviewExist = piimApiClient.checkIfReviewExistsById(input.getEntityId());
                if (!doesReviewExist.getDoesExist()) {
                    throw new EntityNotFoundException(
                            String.format("Review with id %d does not exist.", input.getEntityId()));
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
        }
    }
