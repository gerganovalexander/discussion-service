package com.tinqin.academy.discussion.data.repositories;

import com.tinqin.academy.discussion.data.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {}
