package com.tinqin.academy.discussion.rest;

import comment.deleteallbyentityid.DeleteAllByEntityIdInput;
import comment.deleteallbyentityid.DeleteAllByEntityIdOperation;
import comment.deleteallbyentityid.DeleteAllByEntityIdResult;
import comment.getallbyentityid.GetAllByEntityIdInput;
import comment.getallbyentityid.GetAllByEntityIdOperation;
import comment.getallbyentityid.GetAllByEntityIdResult;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final DeleteAllByEntityIdOperation deleteAllByEntityIdOperation;
    private final GetAllByEntityIdOperation getAllByEntityIdOperation;

    @DeleteMapping("/delete-all-by-entityId")
    public DeleteAllByEntityIdResult deleteAllByEntity(@RequestBody @Valid DeleteAllByEntityIdInput getAllGamesByIdsInput) {
        return deleteAllByEntityIdOperation.process(getAllGamesByIdsInput);
    }


    @GetMapping("/get-all-by-entityId")
    public GetAllByEntityIdResult getAllByEntityId(@RequestBody @Valid GetAllByEntityIdInput input) {
        return getAllByEntityIdOperation.process(input);
    }
}
