package com.tinqin.academy.discussion.rest.controllers;

import comment.update.UpdateCommentInput;
import comment.update.UpdateCommentOperation;
import comment.update.UpdateCommentResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/comments")
public class CommentController {
    private final UpdateCommentOperation updateCommentOperation;

    @PutMapping("/{id}")
    public UpdateCommentResult updateComment(@PathVariable Long id) {
        return updateCommentOperation.process(
                UpdateCommentInput.builder().id(id).build());
    }
}
