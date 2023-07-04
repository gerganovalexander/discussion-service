package operations.createcomment;

import com.tinqin.academy.discussion.api.generics.OperationInput;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCommentInput implements OperationInput {

    @NotEmpty(message = "Comment must not be empty")
    private String comment;
    @NotNull
    @Positive
    private Long userId;
    @NotNull
    @Positive
    private String entityType;
    @NotNull
    @Positive
    private Long entityId;
}
