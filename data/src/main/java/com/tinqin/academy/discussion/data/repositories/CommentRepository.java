package com.tinqin.academy.discussion.data.repositories;

import com.tinqin.academy.discussion.data.models.Comment;
import com.tinqin.academy.discussion.data.models.EntityType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    boolean existsByComment(String commentValue);

    Page<Comment> findAllByEntityIdAndEntityType(Long entityId, EntityType entityType, Pageable pageable);
}
