package entityoutputmodels;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentOutput {
    private Long id;

    private String comment;

    private Long userId;
}
