package com.tinqin.academy.discussion.business.operations.comments;

import com.tinqin.academy.discussion.api.operations.update.UpdateCommentInput;
import com.tinqin.academy.discussion.api.operations.update.UpdateCommentOperation;
import com.tinqin.academy.discussion.api.operations.update.UpdateCommentResult;
import com.tinqin.academy.discussion.data.models.Comment;
import com.tinqin.academy.discussion.data.repositories.CommentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateCommentOperationProcessor implements UpdateCommentOperation {
    private final CommentRepository commentRepository;

    @Override
    public UpdateCommentResult process(final UpdateCommentInput input) {
        Comment commentForUpdate = commentRepository
                .findById(input.getId())
                .orElseThrow(() -> new EntityNotFoundException("Comment with this ID does not exist."));
        commentForUpdate.setComment(input.getComment());
        commentRepository.save(commentForUpdate);

        return UpdateCommentResult.builder()
                .comment(commentForUpdate.getComment())
                .userId(commentForUpdate.getUserId())
                .entityType(commentForUpdate.getEntityType().name())
                .entityId(commentForUpdate.getEntityId())
                .build();
    }
}
