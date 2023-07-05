package com.tinqin.academy.discussion.api.operations.getallbyentityid;

import com.tinqin.academy.discussion.api.generics.OperationInput;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetAllByEntityIdInput implements OperationInput {
    @NotNull
    private Integer page;

    @NotNull
    private Integer limit;

    @NotNull
    private Long entityId;

    @NotNull
    private String entityType;
}
