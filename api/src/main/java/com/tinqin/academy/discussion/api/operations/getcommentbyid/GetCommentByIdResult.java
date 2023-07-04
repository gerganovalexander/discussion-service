package com.tinqin.academy.discussion.api.operations.getcommentbyid;

import com.tinqin.academy.discussion.api.generics.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetCommentByIdResult implements OperationResult {

    private Long id;

    private String comment;

    private Long userId;
}
