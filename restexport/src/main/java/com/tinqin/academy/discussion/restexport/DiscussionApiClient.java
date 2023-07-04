package com.tinqin.academy.discussion.restexport;

import com.tinqin.academy.discussion.api.operations.getcommentbyid.GetCommentByIdResult;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers({"Accept: application/json", "Content-Type: application/json"})
public interface DiscussionApiClient {

    @RequestLine("GET /api/comments/{id}")
    GetCommentByIdResult getCommentById(@Param Long id);
}
