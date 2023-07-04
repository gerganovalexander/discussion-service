package com.tinqin.academy.discussion.shell;

import com.tinqin.academy.discussion.shell.generator.CommentGeneratorOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@RequiredArgsConstructor
public class CommentGenerator {

    private final CommentGeneratorOperation commentGeneratorOperation;

    @ShellMethod("Generates test comments in database")
    public void generateComments(Long numberOfComments, Long entityId) {
        commentGeneratorOperation.generateComments(numberOfComments, entityId);
    }
}
