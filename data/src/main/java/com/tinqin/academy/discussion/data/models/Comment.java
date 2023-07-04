package com.tinqin.academy.discussion.data.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "comments")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String comment;

    private Long userId;

    @Enumerated(EnumType.STRING)
    private EntityType entityType;

    private Long entityId;
}
