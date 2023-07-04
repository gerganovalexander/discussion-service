package com.tinqin.academy.discussion.api.operations.deletecommentbyid;

import com.tinqin.academy.discussion.api.generics.OperationResult;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteCommentByIdResult implements OperationResult {
    boolean success;
}
