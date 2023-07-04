package com.tinqin.academy.discussion.api.operations.getcommentbyid;

import com.tinqin.academy.discussion.api.generics.OperationInput;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetCommentByIdInput implements OperationInput {

    @Positive
    @NotNull
    private Long id;
}
