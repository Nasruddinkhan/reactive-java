package com.mypractice.mono;

import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {
    private static final Path PATH = Paths.get("E:\\eclipse-workspace\\springbootppliction-rabbitmq\\reactive-java\\src\\main\\resources");

    public static Mono<String> read(String fileName) {
        return Mono.fromSupplier(() -> readFile(fileName));
    }

    public static Mono<Void> write(String fileName, String content) {
        return Mono.fromRunnable(() -> writeFile(fileName, content));
    }

    public static Mono<Void> delete(String fileName) {
        return Mono.fromRunnable(() -> deleteFile(fileName));
    }

    public static String readFile(String fileName) {
        try {
            return Files.readString(PATH.resolve(fileName));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void writeFile(String fileName, String fileContent) {
        try {
            Files.writeString(PATH.resolve(fileName), fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void deleteFile(String fileName) {
        try {
            Files.delete(PATH.resolve(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
