package com.tinqin.academy.discussion.rest.controllers;

import com.tinqin.academy.discussion.api.operations.deletecommentbyid.DeleteCommentByIdInput;
import com.tinqin.academy.discussion.api.operations.deletecommentbyid.DeleteCommentByIdOperation;
import com.tinqin.academy.discussion.api.operations.deletecommentbyid.DeleteCommentByIdResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final DeleteCommentByIdOperation deleteCommentByIdOperation;

    @DeleteMapping("/{id}")
    public DeleteCommentByIdResult deleteById(@PathVariable Long id) {
        return deleteCommentByIdOperation.process(
                DeleteCommentByIdInput.builder().id(id).build());
    }
}
