package com.tinqin.academy.discussion.rest;

import com.tinqin.academy.discussion.business.operations.generator.CommentGeneratorOperation;
import com.tinqin.academy.discussion.data.models.Comment;
import com.tinqin.academy.discussion.data.models.EntityType;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@RequiredArgsConstructor
public class CommentGenerator {

    private final CommentGeneratorOperation commentGeneratorOperation;
    @ShellMethod
    public void generateComments(Long numberOfComments, Long entityId) {
        commentGeneratorOperation.generateComments(numberOfComments, entityId);
    }

}
