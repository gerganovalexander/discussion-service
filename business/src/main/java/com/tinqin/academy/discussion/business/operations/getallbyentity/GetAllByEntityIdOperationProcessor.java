package com.tinqin.academy.discussion.business.operations.getallbyentity;

import com.tinqin.academy.discussion.data.models.EntityType;
import com.tinqin.academy.discussion.data.repositories.CommentRepository;
import com.tinqin.academy.discussion.api.operations.getallbyentityid.GetAllByEntityIdInput;
import com.tinqin.academy.discussion.api.operations.getallbyentityid.GetAllByEntityIdOperation;
import com.tinqin.academy.discussion.api.operations.getallbyentityid.GetAllByEntityIdResult;
import entityoutputmodels.CommentOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class GetAllByEntityIdOperationProcessor implements GetAllByEntityIdOperation {

    private final CommentRepository commentRepository;

    @Override
    public GetAllByEntityIdResult process(GetAllByEntityIdInput input) {

        EntityType entityType = EntityType.valueOf(input.getEntityType().toUpperCase());
        return GetAllByEntityIdResult.builder()
                .commentOutput(
                        commentRepository.findAllByEntityIdAndEntityType(input.getEntityId(), entityType).stream()
                                .map(comment -> CommentOutput.builder()
                                        .id(comment.getId())
                                        .userId(comment.getUserId())
                                        .comment(comment.getComment())
                                        .build())
                                .toList())
                .build();
    }
}
