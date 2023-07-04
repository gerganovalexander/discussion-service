package com.tinqin.academy.discussion.rest.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import operations.createcomment.CreateCommentInput;
import operations.createcomment.CreateCommentOperation;
import operations.createcomment.CreateCommentResult;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/comments")
public class  CommentController {

    private final CreateCommentOperation createCommentOperation;

    @PostMapping
    public CreateCommentResult createComment(@RequestBody @Valid CreateCommentInput createCommentInput) {
        return createCommentOperation.process(createCommentInput);
    }
}
