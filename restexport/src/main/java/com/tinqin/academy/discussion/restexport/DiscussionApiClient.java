package com.tinqin.academy.discussion.restexport;

import com.tinqin.academy.discussion.api.operations.createcomment.CreateCommentInput;
import com.tinqin.academy.discussion.api.operations.createcomment.CreateCommentResult;
import com.tinqin.academy.discussion.api.operations.deleteallbyentityid.DeleteAllByEntityIdResult;
import com.tinqin.academy.discussion.api.operations.deletecommentbyid.DeleteCommentByIdResult;
import com.tinqin.academy.discussion.api.operations.getallbyentityid.GetAllByEntityIdResult;
import com.tinqin.academy.discussion.api.operations.getcommentbyid.GetCommentByIdResult;
import com.tinqin.academy.discussion.api.operations.update.UpdateCommentResult;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers({"Accept: application/json", "Content-Type: application/json"})
public interface DiscussionApiClient {

    @RequestLine("PUT /api/comment/{id}")
    UpdateCommentResult updateComment(@Param long id);

    @RequestLine("DELETE /api/comments/{id}")
    DeleteCommentByIdResult deleteCommentById(@Param Long id);

    @RequestLine("DELETE /api/comments/delete-all-by-entityId?entityId={entityId}&entityType={entityType}")
    DeleteAllByEntityIdResult deleteCommentsByEntity(@Param Long entityId, @Param String entityType);

    @RequestLine("POST /api/comments")
    CreateCommentResult createComment(CreateCommentInput createCommentInput);

    @RequestLine(
            """
    GET /api/comments/get-all-by-entityId?entityId={entityId}&entityType={entityType}&page={page}&limit={limit}
    """)
    GetAllByEntityIdResult getAllCommentsByEntityId(
            @Param Long entityId, @Param String entityType, @Param Integer page, @Param Integer limit);

    @RequestLine("GET /api/comments/{id}")
    GetCommentByIdResult getCommentById(@Param Long id);
}
