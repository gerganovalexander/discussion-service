package com.tinqin.academy.discussion.restexport;

import feign.Headers;
import feign.RequestLine;
import operations.createcomment.CreateCommentInput;
import operations.createcomment.CreateCommentResult;

@Headers({"Accept: application/json", "Content-Type: application/json"})
public interface DiscussionApiClient {

    @RequestLine("POST /api/comments")
    CreateCommentResult createComment(CreateCommentInput createCommentInput);
}
