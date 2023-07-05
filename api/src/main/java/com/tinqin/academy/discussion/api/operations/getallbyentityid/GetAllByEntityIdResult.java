package com.tinqin.academy.discussion.api.operations.getallbyentityid;

import com.tinqin.academy.discussion.api.generics.OperationResult;
import entityoutputmodels.CommentOutput;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetAllByEntityIdResult implements OperationResult {
    private Integer page;
    private Integer limit;
    private Long totalItems;
    private List<CommentOutput> commentOutput;
}
