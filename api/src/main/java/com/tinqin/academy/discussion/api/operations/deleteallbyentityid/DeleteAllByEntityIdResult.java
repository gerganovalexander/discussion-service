package com.tinqin.academy.discussion.api.operations.deleteallbyentityid;

import com.tinqin.academy.discussion.api.generics.OperationResult;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteAllByEntityIdResult implements OperationResult {

    private Boolean success;
}
