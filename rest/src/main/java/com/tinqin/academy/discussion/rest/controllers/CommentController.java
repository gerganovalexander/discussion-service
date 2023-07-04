package com.tinqin.academy.discussion.rest.controllers;

import com.tinqin.academy.discussion.api.operations.getcommentbyid.GetCommentByIdInput;
import com.tinqin.academy.discussion.api.operations.getcommentbyid.GetCommentByIdOperation;
import com.tinqin.academy.discussion.api.operations.getcommentbyid.GetCommentByIdResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final GetCommentByIdOperation getCommentByIdOperation;

    @GetMapping("/{id}")
    public GetCommentByIdResult getById(@PathVariable Long id) {
        return getCommentByIdOperation.process(
                GetCommentByIdInput.builder().id(id).build());
    }
}
