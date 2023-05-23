package com.windyu;

import org.jooq.codegen.GenerationTool;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Tool {
    public static void main(String[] args) throws Exception {
        System.out.println(Path.of("src/main/resources/jooq-config.xml").toAbsolutePath().toString());
        GenerationTool.generate(
                Files.readString(
                        Path.of("src/main/resources/jooq-config.xml")
                )
        );
    }
}
