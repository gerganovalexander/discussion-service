package com.tinqin.academy.discussion.restexport;

import com.tinqin.academy.discussion.api.operations.deletecommentbyid.DeleteCommentByIdResult;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers({"Accept: application/json", "Content-Type: application/json"})
public interface DiscussionApiClient {

    @RequestLine("DELETE /api/comments/{id}")
    DeleteCommentByIdResult deleteCategory(@Param Long id);
}
