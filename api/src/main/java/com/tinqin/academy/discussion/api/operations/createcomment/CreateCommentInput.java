package com.tinqin.academy.discussion.api.operations.createcomment;

import com.tinqin.academy.discussion.api.generics.OperationInput;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCommentInput implements OperationInput {

    @NotBlank(message = "Comment must not be empty")
    private String comment;

    @NotNull
    @Positive
    private Long userId;

    @NotNull
    private String entityType;

    @NotNull
    @Positive
    private Long entityId;
}
