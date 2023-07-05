package com.tinqin.academy.discussion.api.operations.update;

import com.tinqin.academy.discussion.api.generics.OperationInput;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateCommentInput implements OperationInput {

    @NotNull
    @Positive
    private Long id;

    @NotNull
    private String comment;
}
