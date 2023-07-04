package comment.deleteallbyentityid;

import com.tinqin.academy.discussion.api.generics.OperationInput;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteAllByEntityIdInput implements OperationInput {
    @NotNull
    private Long entityId;

    @NotNull
    private String entityType;
}
