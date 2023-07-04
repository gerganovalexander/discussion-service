package com.tinqin.academy.discussion.data.repositories;

import com.tinqin.academy.discussion.data.models.Comment;
import com.tinqin.academy.discussion.data.models.EntityType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    boolean existsByComment(String commentValue);

    List<Comment> findAllByEntityIdAndEntityType(Long entityId, EntityType entityType);

}
