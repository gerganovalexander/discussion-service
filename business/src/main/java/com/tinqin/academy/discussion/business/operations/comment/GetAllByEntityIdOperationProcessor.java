package com.tinqin.academy.discussion.business.operations.comment;

import com.tinqin.academy.discussion.data.models.EntityType;
import com.tinqin.academy.discussion.data.repositories.CommentRepository;
import comment.deleteallbyentityid.DeleteAllByEntityIdInput;
import comment.deleteallbyentityid.DeleteAllByEntityIdOperation;
import comment.deleteallbyentityid.DeleteAllByEntityIdResult;
import comment.getallbyentityid.GetAllByEntityIdInput;
import comment.getallbyentityid.GetAllByEntityIdOperation;
import comment.getallbyentityid.GetAllByEntityIdResult;
import entityoutputmodels.CommentOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
