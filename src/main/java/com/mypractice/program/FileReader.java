package com.mypractice.program;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class FileReader {
    private Callable<BufferedReader> openReader(Path path) {
        System.out.println("FileReader.openReader");
        return () -> Files.newBufferedReader(path);
    }

    private BiFunction<BufferedReader, SynchronousSink<String>, BufferedReader> read() {
        return (br, sink) -> {
            try {
                System.out.println("FileReader.read");
                String line = br.readLine();
                if (Objects.isNull(line)) {
                    sink.complete();
                } else {
                    sink.next(line);
                }
            } catch (IOException e) {
                sink.error(e);
                e.printStackTrace();
            }
            return br;
        };
    }

    private Consumer<BufferedReader> closeReader() {
        return br -> {
            try {
                System.out.println("FileReader.closeReader closing file object");
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }

    public Flux<String> read(Path path) {
        return Flux.generate(openReader(path),
                read(),
                closeReader());
    }
}
