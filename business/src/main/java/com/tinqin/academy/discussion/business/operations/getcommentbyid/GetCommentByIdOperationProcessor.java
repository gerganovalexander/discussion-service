package com.tinqin.academy.discussion.business.operations.getcommentbyid;

import com.tinqin.academy.discussion.api.operations.getcommentbyid.GetCommentByIdInput;
import com.tinqin.academy.discussion.api.operations.getcommentbyid.GetCommentByIdOperation;
import com.tinqin.academy.discussion.api.operations.getcommentbyid.GetCommentByIdResult;
import com.tinqin.academy.discussion.data.models.Comment;
import com.tinqin.academy.discussion.data.repositories.CommentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetCommentByIdOperationProcessor implements GetCommentByIdOperation {

    private final CommentRepository commentRepository;

    @Override
    public GetCommentByIdResult process(final GetCommentByIdInput input) {

        Comment comment = commentRepository
                .findById(input.getId())
                .orElseThrow(() ->
                        new EntityNotFoundException(String.format("Comment with id %d not found", input.getId())));

        return GetCommentByIdResult.builder()
                .id(comment.getId())
                .comment(comment.getComment())
                .userId(comment.getUserId())
                .build();
    }
}
