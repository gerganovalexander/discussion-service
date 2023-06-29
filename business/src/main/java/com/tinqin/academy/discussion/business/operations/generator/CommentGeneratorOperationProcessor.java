package com.tinqin.academy.discussion.business.operations.generator;

import com.tinqin.academy.discussion.data.models.Comment;
import com.tinqin.academy.discussion.data.models.EntityType;
import com.tinqin.academy.discussion.data.repositories.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentGeneratorOperationProcessor implements CommentGeneratorOperation {

    private final CommentRepository commentRepository;

    public void generateComments(Long numberOfComments, Long entityId) {
        for (long i = 0; i < numberOfComments; i++) {
            Comment comment = Comment.builder()
                    .comment("Generated comment")
                    .userId(1L)
                    .entityType(i % 2 == 0 ? EntityType.GAME : EntityType.REVIEW)
                    .entityId(entityId)
                    .build();
            commentRepository.save(comment);
        }
    }
}
