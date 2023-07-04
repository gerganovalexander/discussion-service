package com.tinqin.academy.discussion.api.operations.createcomment;

import com.tinqin.academy.discussion.api.generics.OperationResult;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCommentResult implements OperationResult {
    private Long id;

    private String comment;

    private Long userId;

    private String entityType;

    private Long entityId;
}
