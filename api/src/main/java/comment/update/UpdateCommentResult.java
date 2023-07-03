package comment.update;

import com.tinqin.academy.discussion.api.generics.OperationResult;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateCommentResult implements OperationResult {
    private String comment;
    private Long userId;
    //    private EntityType entityType;
    private Long entityId;
}
