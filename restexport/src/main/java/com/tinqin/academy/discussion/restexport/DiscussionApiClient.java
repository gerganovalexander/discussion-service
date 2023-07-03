package com.tinqin.academy.discussion.restexport;

import comment.update.UpdateCommentResult;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers({"Accept: application/json", "Content-Type: application/json"})
public interface DiscussionApiClient {

    @RequestLine("PUT /api/comment/{id}")
    UpdateCommentResult updateComment(@Param long id);
}
