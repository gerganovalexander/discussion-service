package com.tinqin.academy.discussion.business.operations.createcomment;

import com.tinqin.academy.discussion.data.models.EntityType;
import com.tinqin.academy.discussion.data.repositories.CommentRepository;
import com.tinqin.academy.piim.api.game.getbyid.GetByIdGameResult;
import com.tinqin.academy.piim.api.review.getbyid.GetByIdReviewResult;
import com.tinqin.academy.piim.restexport.PiimApiClient;
import jakarta.persistence.EntityExistsException;
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

            switch (input.getEntityType().toLowerCase()) {
                case "game":
                    Optional<GetByIdGameResult> gameType = Optional.ofNullable(piimApiClient.getGameById(input.getEntityId()));
                case "review":
                    Optional<GetByIdReviewResult> reviewType = Optional.ofNullable(piimApiClient.getReviewById(input.getEntityId()));
            }


        if (commentRepository.existsByComment(input.getComment())) {
            throw new EntityExistsException("The same comment already exists");

//            Does the comment need extra validation for existence?
//            How can i make the switch case in another way ?
//            ResultDTO will have all of the fields?
                    }
    }
}
