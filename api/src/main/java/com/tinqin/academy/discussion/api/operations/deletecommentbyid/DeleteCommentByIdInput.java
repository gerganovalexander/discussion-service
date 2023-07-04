package com.tinqin.academy.discussion.api.operations.deletecommentbyid;

import com.tinqin.academy.discussion.api.generics.OperationInput;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteCommentByIdInput implements OperationInput {
    @NotNull
    @Positive
    private Long id;
}
