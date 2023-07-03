package com.tinqin.academy.discussion.business.operations.comment;

import com.tinqin.academy.discussion.data.models.Comment;
import com.tinqin.academy.discussion.data.models.EntityType;
import com.tinqin.academy.discussion.data.repositories.CommentRepository;
import comment.deleteallbyentityid.DeleteAllByEntityIdInput;
import comment.deleteallbyentityid.DeleteAllByEntityIdOperation;
import comment.deleteallbyentityid.DeleteAllByEntityIdResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeleteAllByEntityIdOperationProcessor implements DeleteAllByEntityIdOperation {

    private final CommentRepository commentRepository;

    @Override
    public DeleteAllByEntityIdResult process(DeleteAllByEntityIdInput input) {
        EntityType entityType = EntityType.valueOf(input.getEntityType().toUpperCase());
        commentRepository
                .findAllByEntityIdAndEntityType(input.getEntityId(), entityType)
                .forEach(comment -> {
                    comment.setMarkedForDelete(true);
                    commentRepository.save(comment);
                });
        return DeleteAllByEntityIdResult.builder().success(true).build();
    }
}
