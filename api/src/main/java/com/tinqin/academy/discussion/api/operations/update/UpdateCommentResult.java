package com.tinqin.academy.discussion.api.operations.update;

import com.tinqin.academy.discussion.api.generics.OperationResult;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateCommentResult implements OperationResult {
    private String comment;
    private Long userId;
    private String entityType;
    private Long entityId;
}
