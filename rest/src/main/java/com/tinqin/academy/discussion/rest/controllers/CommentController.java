package com.tinqin.academy.discussion.rest.controllers;

import com.tinqin.academy.discussion.api.operations.deleteallbyentityid.DeleteAllByEntityIdInput;
import com.tinqin.academy.discussion.api.operations.deleteallbyentityid.DeleteAllByEntityIdOperation;
import com.tinqin.academy.discussion.api.operations.deleteallbyentityid.DeleteAllByEntityIdResult;
import com.tinqin.academy.discussion.api.operations.deletecommentbyid.DeleteCommentByIdInput;
import com.tinqin.academy.discussion.api.operations.deletecommentbyid.DeleteCommentByIdOperation;
import com.tinqin.academy.discussion.api.operations.deletecommentbyid.DeleteCommentByIdResult;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final DeleteCommentByIdOperation deleteCommentByIdOperation;
    private final DeleteAllByEntityIdOperation deleteAllByEntityIdOperation;

    @DeleteMapping("/{id}")
    public DeleteCommentByIdResult deleteById(@PathVariable Long id) {
        return deleteCommentByIdOperation.process(
                DeleteCommentByIdInput.builder().id(id).build());
    }

    @DeleteMapping("/delete-all-by-entityId")
    public DeleteAllByEntityIdResult deleteAllByEntity(
            @RequestBody @Valid DeleteAllByEntityIdInput getAllGamesByIdsInput) {
        return deleteAllByEntityIdOperation.process(getAllGamesByIdsInput);
    }
}
