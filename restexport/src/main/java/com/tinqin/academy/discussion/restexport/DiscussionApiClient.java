package com.tinqin.academy.discussion.restexport;

import com.tinqin.academy.discussion.api.operations.deleteallbyentityid.DeleteAllByEntityIdResult;
import com.tinqin.academy.discussion.api.operations.deletecommentbyid.DeleteCommentByIdResult;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers({"Accept: application/json", "Content-Type: application/json"})
public interface DiscussionApiClient {

    @RequestLine("DELETE /api/comments/{id}")
    DeleteCommentByIdResult deleteCommentById(@Param Long id);

    @RequestLine("DELETE /api/comments?entityId={entityId}&entityType={entityType}")
    DeleteAllByEntityIdResult deleteCommentsByEntity(@Param Long entityId, @Param String entityType);
}
