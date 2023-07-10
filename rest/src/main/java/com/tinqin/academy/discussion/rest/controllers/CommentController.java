package com.tinqin.academy.discussion.rest.controllers;

import com.tinqin.academy.discussion.api.operations.createcomment.CreateCommentInput;
import com.tinqin.academy.discussion.api.operations.createcomment.CreateCommentOperation;
import com.tinqin.academy.discussion.api.operations.createcomment.CreateCommentResult;
import com.tinqin.academy.discussion.api.operations.deleteallbyentityid.DeleteAllByEntityIdInput;
import com.tinqin.academy.discussion.api.operations.deleteallbyentityid.DeleteAllByEntityIdOperation;
import com.tinqin.academy.discussion.api.operations.deleteallbyentityid.DeleteAllByEntityIdResult;
import com.tinqin.academy.discussion.api.operations.deletecommentbyid.DeleteCommentByIdInput;
import com.tinqin.academy.discussion.api.operations.deletecommentbyid.DeleteCommentByIdOperation;
import com.tinqin.academy.discussion.api.operations.deletecommentbyid.DeleteCommentByIdResult;
import com.tinqin.academy.discussion.api.operations.getallbyentityid.GetAllByEntityIdInput;
import com.tinqin.academy.discussion.api.operations.getallbyentityid.GetAllByEntityIdOperation;
import com.tinqin.academy.discussion.api.operations.getallbyentityid.GetAllByEntityIdResult;
import com.tinqin.academy.discussion.api.operations.getcommentbyid.GetCommentByIdInput;
import com.tinqin.academy.discussion.api.operations.getcommentbyid.GetCommentByIdOperation;
import com.tinqin.academy.discussion.api.operations.getcommentbyid.GetCommentByIdResult;
import com.tinqin.academy.discussion.api.operations.update.UpdateCommentInput;
import com.tinqin.academy.discussion.api.operations.update.UpdateCommentOperation;
import com.tinqin.academy.discussion.api.operations.update.UpdateCommentResult;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/comments")
public class CommentController extends BaseController {

    private final CreateCommentOperation createCommentOperation;
    private final DeleteCommentByIdOperation deleteCommentByIdOperation;
    private final DeleteAllByEntityIdOperation deleteAllByEntityIdOperation;
    private final GetAllByEntityIdOperation getAllByEntityIdOperation;
    private final GetCommentByIdOperation getCommentByIdOperation;
    private final UpdateCommentOperation updateCommentOperation;

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return handleOperation(deleteCommentByIdOperation.process(
                DeleteCommentByIdInput.builder().id(id).build()));
    }

    @DeleteMapping("/delete-all-by-entityId")
    public ResponseEntity<?> deleteAllByEntity(@RequestBody @Valid DeleteAllByEntityIdInput deleteAllByEntityIdInput) {
        return handleOperation(deleteAllByEntityIdOperation.process(deleteAllByEntityIdInput));
    }

    @PostMapping("/get-all-by-entityId")
    public ResponseEntity<?> getAllByEntityId(@RequestBody @Valid GetAllByEntityIdInput getAllByEntityIdInput) {
        return handleOperation(getAllByEntityIdOperation.process(getAllByEntityIdInput));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return handleOperation(getCommentByIdOperation.process(
                GetCommentByIdInput.builder().id(id).build()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateComment(@PathVariable Long id) {
        return handleOperation(updateCommentOperation.process(
                UpdateCommentInput.builder().id(id).build()));
    }

    @PostMapping
    public ResponseEntity<?> createComment(@RequestBody @Valid CreateCommentInput createCommentInput) {
        return handleOperation(createCommentOperation.process(createCommentInput));
    }
}
