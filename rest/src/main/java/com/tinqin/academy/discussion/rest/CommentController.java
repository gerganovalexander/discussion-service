package com.tinqin.academy.discussion.rest;

import comment.deleteallbyentityid.DeleteAllByEntityIdInput;
import comment.deleteallbyentityid.DeleteAllByEntityIdOperation;
import comment.deleteallbyentityid.DeleteAllByEntityIdResult;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final DeleteAllByEntityIdOperation deleteAllByEntityIdOperation;

    @DeleteMapping("/delete-all-by-entityId")
    public DeleteAllByEntityIdResult deleteAllByEntity(@RequestBody @Valid DeleteAllByEntityIdInput getAllGamesByIdsInput) {
        return deleteAllByEntityIdOperation.process(getAllGamesByIdsInput);
    }
}
