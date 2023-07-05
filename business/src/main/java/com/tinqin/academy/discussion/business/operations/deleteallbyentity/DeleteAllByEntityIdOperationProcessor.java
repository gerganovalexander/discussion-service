package com.tinqin.academy.discussion.business.operations.deleteallbyentity;

import com.tinqin.academy.discussion.api.operations.deleteallbyentityid.DeleteAllByEntityIdInput;
import com.tinqin.academy.discussion.api.operations.deleteallbyentityid.DeleteAllByEntityIdOperation;
import com.tinqin.academy.discussion.api.operations.deleteallbyentityid.DeleteAllByEntityIdResult;
import com.tinqin.academy.discussion.data.models.EntityType;
import com.tinqin.academy.discussion.data.repositories.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteAllByEntityIdOperationProcessor implements DeleteAllByEntityIdOperation {

    private final CommentRepository commentRepository;

    @Override
    public DeleteAllByEntityIdResult process(DeleteAllByEntityIdInput input) {
        EntityType entityType = EntityType.valueOf(input.getEntityType().toUpperCase());
        commentRepository
                .findAllByEntityIdAndEntityType(input.getEntityId(), entityType, Pageable.unpaged())
                .forEach(comment -> {
                    comment.setMarkedForDelete(true);
                    commentRepository.save(comment);
                });
        return DeleteAllByEntityIdResult.builder().success(true).build();
    }
}
