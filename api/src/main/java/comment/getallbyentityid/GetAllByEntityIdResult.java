package comment.getallbyentityid;

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

    private List<CommentOutput> commentOutput;

}
