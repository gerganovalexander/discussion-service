package com.tinqin.academy.discussion.business.operations.deletecommentbyid;

import com.tinqin.academy.discussion.api.operations.deletecommentbyid.DeleteCommentByIdInput;
import com.tinqin.academy.discussion.api.operations.deletecommentbyid.DeleteCommentByIdOperation;
import com.tinqin.academy.discussion.api.operations.deletecommentbyid.DeleteCommentByIdResult;
import com.tinqin.academy.discussion.data.repositories.CommentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCommentByIdOperationProcessor implements DeleteCommentByIdOperation {

    private final CommentRepository commentRepository;

    @Override
    public DeleteCommentByIdResult process(final DeleteCommentByIdInput input) {
        if (!commentRepository.existsById(input.getId()))
            throw new EntityNotFoundException(String.format("Comment with id %d not found", input.getId()));

        commentRepository.deleteById(input.getId());

        return DeleteCommentByIdResult.builder().success(true).build();
    }
}
