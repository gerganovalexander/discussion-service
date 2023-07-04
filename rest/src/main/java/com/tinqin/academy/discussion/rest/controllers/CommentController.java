package com.tinqin.academy.discussion.rest.controllers;

import com.tinqin.academy.discussion.api.operations.getcommentbyid.GetCommentByIdInput;
import com.tinqin.academy.discussion.api.operations.getcommentbyid.GetCommentByIdOperation;
import com.tinqin.academy.discussion.api.operations.getcommentbyid.GetCommentByIdResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tinqin.academy.discussion.api.operations.deleteallbyentityid.DeleteAllByEntityIdInput;
import com.tinqin.academy.discussion.api.operations.deleteallbyentityid.DeleteAllByEntityIdOperation;
import com.tinqin.academy.discussion.api.operations.deleteallbyentityid.DeleteAllByEntityIdResult;
import com.tinqin.academy.discussion.api.operations.deletecommentbyid.DeleteCommentByIdInput;
import com.tinqin.academy.discussion.api.operations.deletecommentbyid.DeleteCommentByIdOperation;
import com.tinqin.academy.discussion.api.operations.deletecommentbyid.DeleteCommentByIdResult;
import com.tinqin.academy.discussion.api.operations.getallbyentityid.GetAllByEntityIdInput;
import com.tinqin.academy.discussion.api.operations.getallbyentityid.GetAllByEntityIdOperation;
import com.tinqin.academy.discussion.api.operations.getallbyentityid.GetAllByEntityIdResult;
import comment.update.UpdateCommentInput;
import comment.update.UpdateCommentOperation;
import comment.update.UpdateCommentResult;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final DeleteCommentByIdOperation deleteCommentByIdOperation;
    private final DeleteAllByEntityIdOperation deleteAllByEntityIdOperation;
    private final GetAllByEntityIdOperation getAllByEntityIdOperation;
    private final GetCommentByIdOperation getCommentByIdOperation;
    private final UpdateCommentOperation updateCommentOperation;

    @DeleteMapping("/{id}")
    public DeleteCommentByIdResult deleteById(@PathVariable Long id) {
        return deleteCommentByIdOperation.process(
                DeleteCommentByIdInput.builder().id(id).build());
    }

    @DeleteMapping("/delete-all-by-entityId")
    public DeleteAllByEntityIdResult deleteAllByEntity(
            @RequestBody @Valid DeleteAllByEntityIdInput deleteAllByEntityIdInput) {
        return deleteAllByEntityIdOperation.process(deleteAllByEntityIdInput);
    }


    @GetMapping("/get-all-by-entityId")
    public GetAllByEntityIdResult getAllByEntityId(
            @RequestBody @Valid GetAllByEntityIdInput getAllByEntityIdInput) {
        return getAllByEntityIdOperation.process(getAllByEntityIdInput);
    }

    @GetMapping("/{id}")
    public GetCommentByIdResult getById(@PathVariable Long id) {
        return getCommentByIdOperation.process(
                GetCommentByIdInput.builder().id(id).build());
    }

    @PutMapping("/{id}")
    public UpdateCommentResult updateComment(@PathVariable Long id) {
        return updateCommentOperation.process(
                UpdateCommentInput.builder().id(id).build());
    }
}
