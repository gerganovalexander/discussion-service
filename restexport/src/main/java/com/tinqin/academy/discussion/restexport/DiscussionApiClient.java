package com.tinqin.academy.discussion.restexport;

import com.tinqin.academy.discussion.api.operations.deleteallbyentityid.DeleteAllByEntityIdResult;
import com.tinqin.academy.discussion.api.operations.deletecommentbyid.DeleteCommentByIdResult;
import com.tinqin.academy.discussion.api.operations.getallbyentityid.GetAllByEntityIdResult;
import com.tinqin.academy.discussion.api.operations.getcommentbyid.GetCommentByIdResult;
import comment.update.UpdateCommentResult;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import operations.createcomment.CreateCommentInput;
import operations.createcomment.CreateCommentResult;

@Headers({"Accept: application/json", "Content-Type: application/json"})
public interface DiscussionApiClient {

    @RequestLine("PUT /api/comment/{id}")
    UpdateCommentResult updateComment(@Param long id);

    @RequestLine("DELETE /api/comments/{id}")
    DeleteCommentByIdResult deleteCommentById(@Param Long id);

    @RequestLine("DELETE /api/comments?entityId={entityId}&entityType={entityType}")
    DeleteAllByEntityIdResult deleteCommentsByEntity(@Param Long entityId, @Param String entityType);

    @RequestLine("POST /api/comments")
    CreateCommentResult createComment(CreateCommentInput createCommentInput);

    @RequestLine("GET /api/comments?entityId={entityId}&entityType={entityType}")
    GetAllByEntityIdResult getAllCommentsByEntityId(@Param Long entityId, @Param String entityType);

    @RequestLine("GET /api/comments/{id}")
    GetCommentByIdResult getCommentById(@Param Long id);
}
